package com.example.ashowcasesearchgithubuser.listuser.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,
    val name: String
)
