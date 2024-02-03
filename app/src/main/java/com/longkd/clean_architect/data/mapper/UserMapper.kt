package com.longkd.clean_architect.data.mapper

import com.longkd.clean_architect.data.remote.response.UserResponse
import com.longkd.clean_architect.domain.model.UserData
/**
 * @Author: longkd
 * @Since: 21:13 - 03/02/2024
 */

fun UserResponse.Data.toDomain() = UserData(avatar,email, firstName, id, lastName)