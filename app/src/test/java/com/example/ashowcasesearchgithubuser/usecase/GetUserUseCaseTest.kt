package com.example.ashowcasesearchgithubuser.usecase

import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse
import com.example.ashowcasesearchgithubuser.listuser.data.repository.UserRepositoryImpl
import com.example.ashowcasesearchgithubuser.listuser.domain.model.User
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
            listOf(
                GithubUserResponse.Item(
                    "asd",
                    1,
                    "ajib",
                    "asd"
                ),
                GithubUserResponse.Item(
                    "asd",
                    2,
                    "keren",
                    "asd"
                )
            ),
            20
        )

        val result = listOf(
            User(1,"ajib"),
            User(2,"keren")
        )

        coEvery {
            mockUserRepo.searchUser(query, page)
        } answers {
            response
        }

        coEvery {
            mockUserRepo.insertUserToDb(result)
        } answers { }

        coEvery {
            mockUserRepo.getUserLocal()
        } answers {
            result
        }

        useCase.getUserList(query, page)
            .collectIndexed { index, value ->
                if(index == 0) value shouldBeEqualTo Result.Loading
                if(index == 1) value shouldBeEqualTo Result.Success(result)
            }
    }
}