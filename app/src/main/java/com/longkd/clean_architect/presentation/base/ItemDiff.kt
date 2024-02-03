package com.longkd.clean_architect.presentation.base

/**
 * @Author: longkd
 * @Since: 21:50 - 03/02/2024
 */
interface ItemDiff {
    fun isItemTheSame(other: ItemDiff): Boolean
    fun isContentTheSame(other: ItemDiff): Boolean
}