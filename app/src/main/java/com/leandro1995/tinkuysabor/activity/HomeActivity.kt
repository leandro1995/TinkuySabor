package com.leandro1995.tinkuysabor.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.ActivityHomeBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil

class HomeActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var activityHomeBinding: ActivityHomeBinding
    private var itemSelect = R.id.navigation_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityHomeBinding = bindingUtil(layoutId = R.layout.activity_home)

        initView()
    }

    private fun initView() {
        (supportFragmentManager.findFragmentById(R.id.homeContentView) as NavHostFragment).navController.apply {
            activityHomeBinding.homeNavigation.setupWithNavController(this)
        }
        activityHomeBinding.homeNavigation.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (itemSelect != item.itemId) {
            itemSelect = item.itemId
            activityHomeBinding.homeContentView.findNavController().navigate(item.itemId)
        }
        return true
    }
}