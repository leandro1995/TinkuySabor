package com.leandro1995.tinkuysabor.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.FragmentHomeBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.mapAsync
import com.leandro1995.tinkuysabor.extension.registerForActivityLocationResult
import com.leandro1995.tinkuysabor.extension.viewLifecycleOwner
import com.leandro1995.tinkuysabor.intent.callback.HomeIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.HomeIntentConfig
import com.leandro1995.tinkuysabor.util.GoogleMapUtil
import com.leandro1995.tinkuysabor.util.LocationUtil
import com.leandro1995.tinkuysabor.viewmodel.HomeViewModel

class HomeFragment : Fragment(), HomeIntentCallBack, OnMapReadyCallback {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()
    private val locationResult = registerForActivityLocationResult(method = {
        animateCameraLocation()
    })
    private lateinit var locationUtil: LocationUtil
    private lateinit var googleMapUtil: GoogleMapUtil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentHomeBinding = bindingUtil(
            layoutId = R.layout.fragment_home, inflater = inflater, container = container
        )
        fragmentHomeBinding.homeViewModel = homeViewModel

        viewLifecycleOwner {
            homeViewModel.homeIntentAction.collect { homeIntentAction ->
                HomeIntentConfig(homeIntentAction = homeIntentAction, homeIntentCallBack = this)
            }
        }

        return fragmentHomeBinding.root
    }

    override fun initView() {
        mapAsync(fragmentManager = childFragmentManager, idMap = R.id.map).getMapAsync(this)
        locationUtil = LocationUtil(activity = requireActivity())
        homeViewModel.action.invoke(HomeViewModel.VERIFY_LOCATION)
    }

    override fun loadingLocationGone() {
        fragmentHomeBinding.locationLoadingViewComponent.gone()
    }

    override fun verifyLocation() {
        locationUtil.apply {
            verifyLocation(method = {
                animateCameraLocation()
            }, messageError = {
                locationResult.launch(it)
            })
        }
    }

    override fun onMapReady(p0: GoogleMap) {
        googleMapUtil = GoogleMapUtil(googleMap = p0)
    }

    @SuppressLint("MissingPermission")
    private fun animateCameraLocation() {
        locationUtil.starLocation { latitude, longitude ->
            googleMapUtil.animateCamera(latLng = LatLng(latitude, longitude))
            homeViewModel.action.invoke(HomeViewModel.LOADING_LOCATION_GONE)
        }
    }
}