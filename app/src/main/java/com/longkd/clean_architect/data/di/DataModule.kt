package com.longkd.clean_architect.data.di

import com.longkd.clean_architect.data.remote.repository.UserRepositoryImpl
import com.longkd.clean_architect.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @Author: longkd
 * @Since: 21:18 - 03/02/2024
 */
@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {
    @Binds
    fun bindDataRepository(repositoryImpl: UserRepositoryImpl): UserRepository
}