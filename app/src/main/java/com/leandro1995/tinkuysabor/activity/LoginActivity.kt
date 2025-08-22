package com.leandro1995.tinkuysabor.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.adapter.CarouselAdapter
import com.leandro1995.tinkuysabor.config.Setting
import com.leandro1995.tinkuysabor.databinding.ActivityLoginBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.lifecycleScopeLaunch
import com.leandro1995.tinkuysabor.fcm.authentication.GoogleFCMAuthentication
import com.leandro1995.tinkuysabor.fcm.login.GoogleFCMLogin
import com.leandro1995.tinkuysabor.intent.event.config.callback.LoginIntentEventCallBack
import com.leandro1995.tinkuysabor.intent.config.event.LoginIntentEventConfig
import com.leandro1995.tinkuysabor.model.design.Message
import com.leandro1995.tinkuysabor.util.MessageUtil
import com.leandro1995.tinkuysabor.util.PermissionUtil
import com.leandro1995.tinkuysabor.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), LoginIntentEventCallBack {

    private lateinit var activityLoginBinding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel>()
    private lateinit var googleFCMLogin: GoogleFCMLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityLoginBinding = bindingUtil(layoutId = R.layout.activity_login)
        activityLoginBinding.loginViewModel = loginViewModel

        initView()

        lifecycleScopeLaunch {
            loginViewModel.intentEventSharedFlow.collect { loginIntentEvent ->
                LoginIntentEventConfig(
                    loginIntentEvent = loginIntentEvent, loginIntentEventCallBack = this
                )
            }
        }
    }

    private fun initView() {
        viewPager2()
        googleFCMLogin = GoogleFCMLogin(application = application)
    }

    private fun viewPager2() {
        activityLoginBinding.carouselPager.apply {
            adapter =
                CarouselAdapter(carouselArrayList = Setting.carouselArrayList(activity = this@LoginActivity))
            activityLoginBinding.carouselIndicator.attachTo(this)
        }
    }

    override fun googleLogin() {
        PermissionUtil.messagingPermission(fragmentActivity = this, method = {
            googleFCMLogin.login { googleIdTokenCredential ->
                loginViewModel.let {
                    it.saveUserProtoDataStore(googleIdTokenCredential = googleIdTokenCredential)
                    it.action.invoke(LoginViewModel.GOOGLE_AUTHENTICATION)
                }
            }
        })
    }

    override fun googleAuthentication(googleFCMAuthentication: GoogleFCMAuthentication) {
        googleFCMAuthentication.registerUser(success = {
            loginViewModel.action.invoke(LoginViewModel.SAVE_PROTO_DATA_STORE)
        }, error = {
            MessageUtil.message(
                context = this, message = Message(
                    descriptionStringRes = R.string.login_register_firebase_message
                )
            )
        })
    }

    override fun startHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finishAffinity()
    }
}