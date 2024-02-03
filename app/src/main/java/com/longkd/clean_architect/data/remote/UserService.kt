package com.longkd.clean_architect.data.remote

import com.longkd.clean_architect.data.remote.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: longkd
 * @Since: 20:40 - 03/02/2024
 */
interface UserService {
    @GET("api/users")
    suspend fun getAllData(@Query("page") page: Int): UserResponse
}