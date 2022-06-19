package com.example.ashowcasesearchgithubuser.injector

import com.example.ashowcasesearchgithubuser.listuser.data.repository.UserRepositoryImpl
import com.example.ashowcasesearchgithubuser.listuser.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(repository: UserRepositoryImpl) : UserRepository

}