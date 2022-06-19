package com.example.ashowcasesearchgithubuser.data.remote

import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkServices {

    @GET("search/users")
    suspend fun search(
        @Query("q") query : String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ) : GithubUserResponse

}