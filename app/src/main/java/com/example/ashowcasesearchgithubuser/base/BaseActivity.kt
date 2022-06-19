package com.example.ashowcasesearchgithubuser.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private lateinit var _binding: VB
    val binding: VB
        get() {
            if (::_binding.isInitialized) return _binding
            else _binding = getViewBinding()
            return _binding
        }

    protected abstract fun getViewBinding(): VB
    protected abstract fun getFragmentContainer(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(getViewBinding().root)
    }

    protected fun loadFragment(fragment: Fragment) {
        if (getFragmentContainer() != 0) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(getFragmentContainer(), fragment, fragment.javaClass.toString())
                .addToBackStack(null)
                .commit()
        }
    }
}