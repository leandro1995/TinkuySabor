package com.leandro1995.tinkuysabor.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.ActivityHomeBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityHomeBinding = bindingUtil(layoutId = R.layout.activity_home)

        initView()
    }

    private fun initView() {
        (supportFragmentManager.findFragmentById(R.id.homeContentView) as NavHostFragment).navController.apply {
            activityHomeBinding.homeNavigation.setupWithNavController(this)
        }
    }
}