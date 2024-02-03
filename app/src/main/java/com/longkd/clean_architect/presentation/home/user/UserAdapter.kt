package com.longkd.clean_architect.presentation.home.user

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.longkd.clean_architect.databinding.ItemUserBinding
import com.longkd.clean_architect.domain.model.UserData
import com.longkd.clean_architect.presentation.base.BaseListAdapter
import com.longkd.clean_architect.presentation.base.BaseViewHolder


/**
 * @Author: longkd
 * @Since: 20:49 - 13/08/2023
 */
class UserAdapter :
    BaseListAdapter<UserData, UserAdapter.UserViewHolder>() {

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<UserData, *> {
        return UserViewHolder(ItemUserBinding.inflate(layoutInflater, parent, false))
    }

    inner class UserViewHolder(binding: ItemUserBinding) :
        BaseViewHolder<UserData, ItemUserBinding>(binding) {
        @SuppressLint("SetTextI18n")
        override fun onBind(item: UserData) {
            Glide.with(itemView.context).load(item.avatar).into(binding.imgUser)
            binding.txtName.text = "${item.firstName} ${item.lastName}"
            binding.txtEmail.text = item.email
        }
    }
}