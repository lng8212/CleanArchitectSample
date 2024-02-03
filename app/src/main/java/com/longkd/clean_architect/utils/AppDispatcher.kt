package com.longkd.clean_architect.utils

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

/**
 * @Author: longkd
 * @Since: 21:04 - 03/02/2024
 */

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppDispatcher(val petDispatcher: DispatcherType)

enum class DispatcherType {
    Default,
    IO
}


@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @Provides
    @AppDispatcher(DispatcherType.IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @AppDispatcher(DispatcherType.Default)
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}