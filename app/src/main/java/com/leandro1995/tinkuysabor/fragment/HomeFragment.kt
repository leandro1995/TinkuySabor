package com.leandro1995.tinkuysabor.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.google.android.gms.maps.model.LatLng
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.FragmentHomeBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.registerForActivityLocationResult
import com.leandro1995.tinkuysabor.extension.viewLifecycleOwner
import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.intent.callback.action.HomeIntentActionCallBack
import com.leandro1995.tinkuysabor.intent.config.action.HomeIntentActionConfig
import com.leandro1995.tinkuysabor.model.design.Message
import com.leandro1995.tinkuysabor.util.LocationUtil
import com.leandro1995.tinkuysabor.util.MessageUtil
import com.leandro1995.tinkuysabor.viewmodel.HomeViewModel

class HomeFragment : Fragment(), HomeIntentActionCallBack {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private val homeViewModel by navGraphViewModels<HomeViewModel>(R.id.home_navigation)
    private lateinit var locationUtil: LocationUtil
    private val locationLaunch = registerForActivityLocationResult(method = {
        homeViewModel.action.invoke(HomeViewModel.GPS_LOCATION)
    }, methodError = {
        MessageUtil.message(
            requireActivity(),
            Message(descriptionStringRes = R.string.verify_location_message),
            method = {
                homeViewModel.action.invoke(HomeViewModel.VERIFY_GPS_LOCATION)
            })
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentHomeBinding = bindingUtil(
            layoutId = R.layout.fragment_home, inflater = inflater, container = container
        )
        fragmentHomeBinding.homeViewModel = homeViewModel

        locationUtil = LocationUtil(activity = requireActivity())

        viewLifecycleOwner {
            homeViewModel.intentActionStateFlow.collect { homeIntentAction ->
                HomeIntentActionConfig(
                    homeIntentAction = homeIntentAction, homeIntentActionCallBack = this
                )
            }
        }

        return fragmentHomeBinding.root
    }

    @SuppressLint("MissingPermission")
    override fun view(view: HomeIntentAction) {
        fragmentHomeBinding.apply {
            locationLoadingViewComponent.visibleLoading(isVisible = view.locationLoading.isVisible)
        }

        locationUtil.verifyLocation(isStart = view.isVerifyLocation, method = {
            homeViewModel.action.invoke(HomeViewModel.GPS_LOCATION)
        }, messageError = {
            locationLaunch.launch(it)
        })

        locationUtil.starLocation(
            isStart = view.isStartLocation, method = { latitude, longitude ->
                homeViewModel.personLocation(latLng = LatLng(latitude, longitude))
            })
    }

    override fun initView() {
        homeViewModel.action.invoke(HomeViewModel.VERIFY_GPS_LOCATION)
    }

    override fun onDestroyView() {
        locationUtil.stopLocation()
        super.onDestroyView()
    }
}