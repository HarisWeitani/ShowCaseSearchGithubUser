package com.example.ashowcasesearchgithubuser.listuser.data.repository

import com.example.ashowcasesearchgithubuser.data.remote.NetworkServices
import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse
import com.example.ashowcasesearchgithubuser.listuser.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: NetworkServices) : UserRepository {

    override suspend fun searchUser(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): GithubUserResponse = api.search(query, page, itemsPerPage)
}