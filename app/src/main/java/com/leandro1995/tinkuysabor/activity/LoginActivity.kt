package com.leandro1995.tinkuysabor.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.adapter.CarouselAdapter
import com.leandro1995.tinkuysabor.config.Setting
import com.leandro1995.tinkuysabor.databinding.ActivityLoginBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var activityLoginBinding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityLoginBinding = bindingUtil(layoutId = R.layout.activity_login)
        activityLoginBinding.loginViewModel = loginViewModel
    }

    private fun initView() {
        findViewById<ViewPager2>(R.id.carousel_pager).adapter =
            CarouselAdapter(carouselArrayList = Setting.carouselArrayList(activity = this))
    }
}