package com.leandro1995.tinkuysabor

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.leandro1995.tinkuysabor.activity.HomeActivity
import com.leandro1995.tinkuysabor.background.config.TimeType
import com.leandro1995.tinkuysabor.background.coroutine.TimerCoroutine
import com.leandro1995.tinkuysabor.viewmodel.SplashViewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val timeCoroutine = TimerCoroutine(timeType = TimeType.SECOND, time = TIME_OUT)
    private val splashViewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * TODO TEMPORAL LUEGO LO ADAPTO CON LO NUEVO QUE SE ESTA DESARROLLANDO
         */
        installSplashScreen().setKeepOnScreenCondition { true }

        timeCoroutine.timeStart {
            startActivity(Intent(this, HomeActivity::class.java))
            finishAffinity()
        }

        /*lifecycleScopeLaunch {
            splashViewModel.splashIntentAction.collect { splashIntentAction ->
                SplashIntentConfig(
                    splashIntentAction = splashIntentAction, splashIntentCallBack = this
                )
            }
        }*/
    }

    /*override fun initView() {
        splashScreenConfig()
    }*/

    /*override fun viewActivity(activity: Activity) {
        startActivity(Intent(this, activity::class.java))
        finishAffinity()
    }

    private fun splashScreenConfig() {
        installSplashScreen().setKeepOnScreenCondition { true }

        timeCoroutine.timeStart {
            splashViewModel.action.invoke(SplashViewModel.VIEW_ACTIVITY)
        }
    }*/

    companion object {
        private const val TIME_OUT = 2L
    }
}