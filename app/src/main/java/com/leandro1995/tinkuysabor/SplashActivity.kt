package com.leandro1995.tinkuysabor

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.leandro1995.tinkuysabor.activity.LoginActivity
import com.leandro1995.tinkuysabor.background.config.TimeType
import com.leandro1995.tinkuysabor.background.coroutine.TimerCoroutine

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val timeCoroutine = TimerCoroutine(timeType = TimeType.SECOND, time = TIME_OUT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition { true }

        timeCoroutine.timeStart {
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()
        }
    }

    companion object {
        private const val TIME_OUT = 5L
    }
}