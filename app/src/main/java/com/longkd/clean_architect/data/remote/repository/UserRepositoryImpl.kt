package com.longkd.clean_architect.data.remote.repository

import com.longkd.clean_architect.data.mapper.toDomain
import com.longkd.clean_architect.data.remote.UserService
import com.longkd.clean_architect.domain.model.UserData
import com.longkd.clean_architect.domain.repository.UserRepository
import com.longkd.clean_architect.utils.AppDispatcher
import com.longkd.clean_architect.utils.DispatcherType
import com.longkd.clean_architect.utils.runSuspendCatching
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 21:00 - 03/02/2024
 */
class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    @AppDispatcher(DispatcherType.IO) private val ioDispatcher: CoroutineDispatcher,
) : UserRepository {
    override suspend fun getAllData(page: Int): Result<List<UserData>> =
        runSuspendCatching {
            withContext(ioDispatcher) {
                userService.getAllData(page).data.map {it.toDomain()}
            }
        }
}