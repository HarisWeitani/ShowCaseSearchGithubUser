package com.example.ashowcasesearchgithubuser.listuser.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.ashowcasesearchgithubuser.base.BaseActivity
import com.example.ashowcasesearchgithubuser.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListUserActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun getFragmentContainer(): Int = 0

    private val viewModel : ListUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ajib", "on Create")
        viewModel.getUserList()
    }

}