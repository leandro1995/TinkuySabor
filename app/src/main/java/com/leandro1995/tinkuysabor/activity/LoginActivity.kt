package com.leandro1995.tinkuysabor.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.adapter.CarouselAdapter
import com.leandro1995.tinkuysabor.config.Setting
import com.leandro1995.tinkuysabor.databinding.ActivityLoginBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.lifecycleScopeLaunch
import com.leandro1995.tinkuysabor.intent.callback.LoginIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.LoginIntentConfig
import com.leandro1995.tinkuysabor.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), LoginIntentCallBack {

    private lateinit var activityLoginBinding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityLoginBinding = bindingUtil(layoutId = R.layout.activity_login)
        activityLoginBinding.loginViewModel = loginViewModel

        lifecycleScopeLaunch {
            loginViewModel.loginIntentAction.collect { loginIntentAction ->
                LoginIntentConfig(
                    loginIntentAction = loginIntentAction, loginIntentCallBack = this
                )
            }
        }
    }

    override fun initView() {
        viewPager2()
    }

    private fun viewPager2() {
        activityLoginBinding.carouselPager.apply {
            adapter =
                CarouselAdapter(carouselArrayList = Setting.carouselArrayList(activity = this@LoginActivity))
        }
    }
}