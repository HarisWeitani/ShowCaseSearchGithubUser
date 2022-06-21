package com.example.ashowcasesearchgithubuser.usecase

import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse
import com.example.ashowcasesearchgithubuser.listuser.data.repository.UserRepositoryImpl
import com.example.ashowcasesearchgithubuser.listuser.domain.usecase.GetUserUseCase
import com.example.ashowcasesearchgithubuser.util.Result
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test

class GetUserUseCaseTest {

    @MockK
    private lateinit var mockUserRepo: UserRepositoryImpl

    private lateinit var useCase: GetUserUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetUserUseCase(mockUserRepo)
    }

    @Test
    fun `test success`() = runBlocking {
        val query = "haris"
        val page = 1
        val response = GithubUserResponse(
            listOf(),
            20
        )

        coEvery {
            mockUserRepo.searchUser(query, page)
        } answers {
            response
        }

        useCase.getUserList(query, page)
            .collectIndexed { index, value ->
                if(index == 0) value shouldBeEqualTo Result.Loading
                if(index == 1) value shouldBeEqualTo Result.Success(response)
            }
    }
}