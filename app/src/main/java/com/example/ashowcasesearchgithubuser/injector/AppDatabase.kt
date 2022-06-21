package com.example.ashowcasesearchgithubuser.injector

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ashowcasesearchgithubuser.data.local.UserDao
import com.example.ashowcasesearchgithubuser.listuser.domain.model.User

@Database(
    entities = [
        User::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}