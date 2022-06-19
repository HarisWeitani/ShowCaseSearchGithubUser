package com.example.ashowcasesearchgithubuser.listuser.data.repository

import com.example.ashowcasesearchgithubuser.data.remote.NetworkServices
import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse
import com.example.ashowcasesearchgithubuser.listuser.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(val api: NetworkServices) : UserRepository {

    override suspend fun searchUser(): GithubUserResponse = api.search("har",0,10)
}