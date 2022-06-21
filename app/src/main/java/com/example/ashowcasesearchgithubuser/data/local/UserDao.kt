package com.example.ashowcasesearchgithubuser.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ashowcasesearchgithubuser.listuser.domain.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(data : List<User>)

    @Query("select * from Users")
    suspend fun getUsers() : List<User>

}