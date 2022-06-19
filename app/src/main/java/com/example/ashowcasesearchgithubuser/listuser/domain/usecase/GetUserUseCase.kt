package com.example.ashowcasesearchgithubuser.listuser.domain.usecase

import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse
import com.example.ashowcasesearchgithubuser.listuser.domain.repository.UserRepository
import com.example.ashowcasesearchgithubuser.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepo: UserRepository){

    fun getUserList() : Flow<Result<GithubUserResponse>> {
        return flow {
            try {
                emit(Result.Loading)
                val result = userRepo.searchUser()
                emit(Result.Success(result))
            } catch (e: Exception) {
                emit(Result.Failure(e))
            }
        }.flowOn(Dispatchers.IO)
    }

}