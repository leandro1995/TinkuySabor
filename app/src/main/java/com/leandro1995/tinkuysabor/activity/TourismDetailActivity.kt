package com.leandro1995.tinkuysabor.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.ActivityTourismDetailBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.lifecycleScopeLaunch
import com.leandro1995.tinkuysabor.intent.callback.TourismDetailIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.TourismDetailIntentConfig
import com.leandro1995.tinkuysabor.viewmodel.TourismDetailViewModel

class TourismDetailActivity : AppCompatActivity(), TourismDetailIntentCallBack {

    private lateinit var activityTourismDetailBinding: ActivityTourismDetailBinding
    private val tourismDetailViewModel by viewModels<TourismDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityTourismDetailBinding = bindingUtil(layoutId = R.layout.activity_tourism_detail)
        activityTourismDetailBinding.tourismDetailViewModel = tourismDetailViewModel

        lifecycleScopeLaunch {
            tourismDetailViewModel.tourismDetailIntentAction.collect { tourismDetailIntentAction ->
                TourismDetailIntentConfig(
                    tourismDetailIntentAction = tourismDetailIntentAction,
                    tourismDetailIntentCallBack = this
                )
            }
        }
    }

    override fun initView() {

    }
}