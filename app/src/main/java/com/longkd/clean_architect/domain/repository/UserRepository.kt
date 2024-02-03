package com.longkd.clean_architect.domain.repository

import com.longkd.clean_architect.domain.model.UserData

/**
 * @Author: longkd
 * @Since: 20:56 - 03/02/2024
 */
interface UserRepository {
    suspend fun getAllData(page: Int) :  Result<List<UserData>>
}