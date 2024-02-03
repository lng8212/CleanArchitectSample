package com.longkd.clean_architect.data.remote

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author: longkd
 * @Since: 20:41 - 03/02/2024
 */
class NetworkInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain
            .request()
            .newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Accept", "text/plain")
            .addHeader("Accept", "*/*")
            .addHeader("Content-Type", "application/json")
            .build()
            .let(chain::proceed)
    }
}