package com.longkd.clean_architect.domain.usecase

import com.longkd.clean_architect.domain.model.UserData
import com.longkd.clean_architect.domain.repository.UserRepository
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 21:22 - 03/02/2024
 */
class GetAllUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(page: Int): Result<List<UserData>> = userRepository.getAllData(page)
}