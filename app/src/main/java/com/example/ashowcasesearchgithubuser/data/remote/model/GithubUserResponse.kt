package com.example.ashowcasesearchgithubuser.data.remote.model


import androidx.annotation.Keep
import com.example.ashowcasesearchgithubuser.listuser.domain.model.User

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

    companion object {
        fun map(response: GithubUserResponse) : List<User> {
            val arr = ArrayList<User>()
            for ( data in response.items) {
                arr.add(
                    User(
                        userId = data.id,
                        name = data.login
                    )
                )
            }
            return arr
        }
    }
}