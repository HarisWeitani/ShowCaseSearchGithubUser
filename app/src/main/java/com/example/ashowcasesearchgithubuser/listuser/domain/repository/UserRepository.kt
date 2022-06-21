package com.example.ashowcasesearchgithubuser.listuser.domain.repository

import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse
import com.example.ashowcasesearchgithubuser.listuser.domain.model.User

interface UserRepository {
    suspend fun searchUser(
        query: String,
        page: Int,
        itemsPerPage: Int = 10
    ) : GithubUserResponse

    suspend fun insertUserToDb(datas: List<User>)

    suspend fun getUserLocal() : List<User>
}