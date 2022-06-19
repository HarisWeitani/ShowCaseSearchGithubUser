package com.example.ashowcasesearchgithubuser.listuser.domain.repository

import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse

interface UserRepository {
    suspend fun searchUser() : GithubUserResponse
}