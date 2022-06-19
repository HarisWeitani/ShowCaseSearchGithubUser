package com.example.ashowcasesearchgithubuser.data.remote.model


import androidx.annotation.Keep

@Keep
data class GithubUserResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
) {
    @Keep
    data class Item(
        val avatar_url: String,
        val events_url: String,
        val followers_url: String,
        val following_url: String,
        val gists_url: String,
        val gravatar_id: String,
        val html_url: String,
        val id: Int,
        val login: String,
        val node_id: String,
        val organizations_url: String,
        val received_events_url: String,
        val repos_url: String,
        val score: Double,
        val site_admin: Boolean,
        val starred_url: String,
        val subscriptions_url: String,
        val type: String,
        val url: String
    )
}