package com.example.ashowcasesearchgithubuser.injector

import android.content.Context
import androidx.room.Room
import com.example.ashowcasesearchgithubuser.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java,"GITHUB_USER.db").build()

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()

}