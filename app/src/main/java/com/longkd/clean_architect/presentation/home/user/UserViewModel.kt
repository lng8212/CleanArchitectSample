package com.longkd.clean_architect.presentation.home.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.longkd.clean_architect.domain.usecase.GetAllUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 21:26 - 03/02/2024
 */

@HiltViewModel
class UserViewModel @Inject constructor(private val getAllUserUseCase: GetAllUserUseCase): ViewModel(){

    private val _uiState = MutableStateFlow(value = UserUiState.initial())
    val uiState = _uiState.asStateFlow()

    init {
        getData()
    }
    private fun getData(){
        viewModelScope.launch {
            getAllUserUseCase(_uiState.value.page).fold(
                onSuccess = {listData->
                  _uiState.update {
                      it.copy(listUser = listData)
                  }
                },
                onFailure = {
                    _uiState.update {
                        it.copy(listUser = emptyList())
                    }
                }
            )
        }

    }

}