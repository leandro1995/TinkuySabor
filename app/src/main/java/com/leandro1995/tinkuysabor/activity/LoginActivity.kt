package com.leandro1995.tinkuysabor.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.adapter.CarouselAdapter
import com.leandro1995.tinkuysabor.config.Setting

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    private fun initView() {
        findViewById<ViewPager2>(R.id.carousel_pager).adapter =
            CarouselAdapter(carouselArrayList = Setting.carouselArrayList(activity = this))
    }
}