package com.longkd.clean_architect.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

/**
 * @Author: longkd
 * @Since: 21:44 - 03/02/2024
 */
fun Fragment.launchAndRepeatStarted(
    vararg launchBlocks: suspend () -> Unit,
    doAfterLaunch: (() -> Unit)? = null
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            launchBlocks.forEach { launch { it() } }
            doAfterLaunch?.invoke()
        }
    }
}
