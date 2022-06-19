package com.example.ashowcasesearchgithubuser.listuser.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse
import com.example.ashowcasesearchgithubuser.listuser.domain.usecase.GetUserUseCase
import com.example.ashowcasesearchgithubuser.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListUserViewModel @Inject constructor(private val useCase: GetUserUseCase): ViewModel(){

    fun getUserList() {
        Log.d("ajib","start View Model")
        viewModelScope.launch {
            useCase.getUserList()
                .flowOn(Dispatchers.Default)
                .collect{
                    when (it) {
                        is Result.Loading -> {
                            Log.d("ajib","Loading")
                        }
                        is Result.Failure -> {
                            Log.d("ajib","${it.throwable}")
                        }
                        is Result.Success -> {
                            Log.d("ajib","${it.data}")
                        }
                    }
                }
        }
    }
}