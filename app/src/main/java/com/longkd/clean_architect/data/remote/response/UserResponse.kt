package com.longkd.clean_architect.data.remote.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @Author: longkd
 * @Since: 20:42 - 03/02/2024
 */

@Keep
@JsonClass(generateAdapter = true)
data class UserResponse(
    @Json(name = "data")
    val data: List<Data>,
    @Json(name = "page")
    val page: Int,
    @Json(name = "per_page")
    val perPage: Int,
    @Json(name = "support")
    val support: Support,
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int
) {

    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "avatar")
        val avatar: String,
        @Json(name = "email")
        val email: String,
        @Json(name = "first_name")
        val firstName: String,
        @Json(name = "id")
        val id: Int,
        @Json(name = "last_name")
        val lastName: String
    )

    @JsonClass(generateAdapter = true)
    data class Support(
        @Json(name = "text")
        val text: String,
        @Json(name = "url")
        val url: String
    )
}