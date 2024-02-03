package com.longkd.clean_architect.domain.model

import com.squareup.moshi.Json

/**
 * @Author: longkd
 * @Since: 21:08 - 03/02/2024
 */
data class UserData (
    val avatar: String,
    val email: String,
    val firstName: String,
    val id: Int,
    val lastName: String
)