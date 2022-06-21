package com.example.ashowcasesearchgithubuser.data.remote.model


import androidx.annotation.Keep

@Keep
data class GithubUserResponse(
    val items: List<Item>,
    val total_count: Int
) {
    @Keep
    data class Item(
        val avatar_url: String,
        val gists_url: String,
        val gravatar_id: String,
        val id: Int,
        val login: String,
        val type: String,
        val url: String
    )
}