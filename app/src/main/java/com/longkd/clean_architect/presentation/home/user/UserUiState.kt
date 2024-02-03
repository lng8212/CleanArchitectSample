package com.longkd.clean_architect.presentation.home.user

import com.longkd.clean_architect.domain.model.UserData

/**
 * @Author: longkd
 * @Since: 21:26 - 03/02/2024
 */
data class UserUiState(
    val listUser: List<UserData>,
    val page: Int
){
    companion object{
        fun initial() = UserUiState(emptyList(),1)
    }
}