package com.example.ashowcasesearchgithubuser.listuser.domain.repository

import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse

interface UserRepository {
    suspend fun searchUser(
        query: String,
        page: Int,
        itemsPerPage: Int = 10
    ) : GithubUserResponse
}