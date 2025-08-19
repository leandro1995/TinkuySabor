package com.leandro1995.tinkuysabor.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.config.Setting
import com.leandro1995.tinkuysabor.databinding.ActivityTourismDetailBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.lifecycleScopeLaunch
import com.leandro1995.tinkuysabor.extension.mapAsync
import com.leandro1995.tinkuysabor.extension.putExtraParcelable
import com.leandro1995.tinkuysabor.intent.callback.TourismDetailIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.TourismDetailIntentConfig
import com.leandro1995.tinkuysabor.model.design.Toolbar
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.util.GoogleMapUtil
import com.leandro1995.tinkuysabor.viewmodel.TourismDetailViewModel

class TourismDetailActivity : AppCompatActivity(), TourismDetailIntentCallBack, OnMapReadyCallback {

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
        tourismDetailViewModel.tour =
            Setting.TOUR_PUT_EXTRA.putExtraParcelable<Tour>(activity = this)

        Toolbar(
            materialToolbar = activityTourismDetailBinding.includeAppbar.toolbar,
            isBack = true,
            title = tourismDetailViewModel.tour!!.title
        ).create {
            finish()
        }

        mapAsync(fragmentManager = supportFragmentManager, idMap = R.id.map).getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        GoogleMapUtil(googleMap = p0).apply {
            animateCamera(latLng = tourismDetailViewModel.tour?.latLng()!!, zoom = 15f)
        }
    }
}