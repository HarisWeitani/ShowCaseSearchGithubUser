package com.example.ashowcasesearchgithubuser.listuser.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse
import com.example.ashowcasesearchgithubuser.listuser.domain.usecase.GetUserUseCase
import com.example.ashowcasesearchgithubuser.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListUserViewModel @Inject constructor(private val useCase: GetUserUseCase) : ViewModel() {

    private val _users = MutableLiveData<List<GithubUserResponse.Item>>()
    val users : LiveData<List<GithubUserResponse.Item>> get() = _users

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> get() = _isLoading

    fun getUserList(query: String, page: Int) {
        viewModelScope.launch {
            useCase.getUserList(query, page)
                .flowOn(Dispatchers.Default)
                .collect {
                    when (it) {
                        is Result.Loading -> _isLoading.value = false
                        is Result.Failure -> {
                            _isLoading.value = false
                        }
                        is Result.Success -> {
                            _isLoading.value = false
                            _users.value = it.data.items
                        }
                    }
                }
        }
    }
}