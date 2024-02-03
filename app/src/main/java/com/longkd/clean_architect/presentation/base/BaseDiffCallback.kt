package com.longkd.clean_architect.presentation.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/**
 * @Author: longkd
 * @Since: 21:49 - 03/02/2024
 */
class BaseDiffCallback<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return if (oldItem is ItemDiff) {
            oldItem.isItemTheSame(newItem as ItemDiff)
        } else {
            oldItem == newItem
        }
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return if (oldItem is ItemDiff) {
            oldItem.isContentTheSame(newItem as ItemDiff)
        } else {
            oldItem == newItem
        }
    }
}
