package com.longkd.clean_architect.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.lang.reflect.Method

/**
 * @Author: longkd
 * @Since: 21:46 - 03/02/2024
 */
abstract class BaseListAdapter<T : Any, VH : BaseViewHolder<T, *>> :
    ListAdapter<T, BaseViewHolder<T, *>>(
        BaseDiffCallback<T>()
    ) {
    open val enableLoadMore: Boolean = false


    private var defaultVHClass: Class<BaseViewHolder<T, *>>? = null

    private var inflaterViewBinding: Method? = null

    protected val thresholdInvisibleItem: Int? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, *> {
        val layoutInflater = LayoutInflater.from(parent.context)
        return getViewHolder(layoutInflater, parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, *>, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<T, *>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            holder.onBindPayLoad(getItem(position))
        } else holder.onBind(getItem(position))
    }

    fun submitList(list: List<T>?, extend: Boolean = false) {
        if (extend) {
            val newList = currentList.toMutableList()
            newList.addAll(list ?: emptyList())
            super.submitList(newList)
        } else {
            super.submitList(list?.toList())
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getViewType(position)
    }

    override fun getItemCount(): Int =
        if (enableLoadMore) currentList.size + 1 else currentList.size

    private fun isLastPosition(position: Int): Boolean = position >= itemCount - 1

    fun getRecyclerViewOrientation(recyclerView: RecyclerView): Int {
        return recyclerView.layoutManager.let {
            when (it) {
                is LinearLayoutManager -> {
                    it.orientation
                }

                is StaggeredGridLayoutManager -> {
                    it.orientation
                }

                else -> {
                    RecyclerView.VERTICAL
                }
            }
        }
    }

    open fun getViewType(position: Int): Int = 0

    //need override
    abstract fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<T, *>
}