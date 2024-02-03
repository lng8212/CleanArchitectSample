package com.longkd.clean_architect.presentation.home.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.longkd.clean_architect.databinding.FragmentFirstBinding
import com.longkd.clean_architect.extension.launchAndRepeatStarted
import com.longkd.clean_architect.presentation.base.BaseFragment

import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author: longkd
 * @Since: 20:16 - 03/02/2024
 */

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {
    private val viewModel by viewModels<UserViewModel>()

    private val userAdapter by lazy(LazyThreadSafetyMode.NONE) {
        UserAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        observerUiState()
    }

    private fun setUpViews() {
        binding.rcvMain.adapter = userAdapter
    }

    private fun observerUiState() {
        launchAndRepeatStarted({
            viewModel.uiState.collect(::renderUiState)
        })
    }

    private fun renderUiState(uiState: UserUiState){
        userAdapter.submitList(uiState.listUser)
    }
}