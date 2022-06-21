package com.example.ashowcasesearchgithubuser.listuser.ui

import com.example.ashowcasesearchgithubuser.data.remote.model.GithubUserResponse
import com.example.ashowcasesearchgithubuser.listuser.domain.usecase.GetUserUseCase
import com.example.ashowcasesearchgithubuser.util.Result
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ListUserViewModelTest {

    @MockK
    private lateinit var mockUserUseCase: GetUserUseCase

    private lateinit var viewModel: ListUserViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = ListUserViewModel(mockUserUseCase)
    }

    @Test
    fun `test success`() = runTest {
        val query = "haris"
        val page = 1

        val response = Result.Success(
            GithubUserResponse(
                listOf(),
                20
            )
        )

        viewModel.getUserList(query, page)

        viewModel.users.observeForever {
            it shouldBeEqualTo response
        }

    }
}