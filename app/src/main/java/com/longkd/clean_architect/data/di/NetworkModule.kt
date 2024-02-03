package com.longkd.clean_architect.data.di

import com.longkd.clean_architect.BuildConfig
import com.longkd.clean_architect.data.remote.NetworkInterceptor
import com.longkd.clean_architect.data.remote.UserService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * @Author: longkd
 * @Since: 20:47 - 03/02/2024
 */


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseUrlQualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApiRequest


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @BaseUrlQualifier
    fun provideURL(): String = BuildConfig.BASE_URL

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    fun provideNetworkInterceptor(): NetworkInterceptor = NetworkInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authorizationInterceptor: NetworkInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .addInterceptor(authorizationInterceptor)
            .build()

    @Provides
    @Singleton
    @ApiRequest
    fun provideRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient,
        @BaseUrlQualifier baseUrl: String,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    fun providePetsService(
        @ApiRequest retrofit: Retrofit,
    ): UserService = retrofit.create()
}