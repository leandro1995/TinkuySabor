package com.leandro1995.tinkuysabor.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.adapter.TourBottomSheetAdapter
import com.leandro1995.tinkuysabor.adapter.config.callback.TourBottomSheetAdapterCallBack
import com.leandro1995.tinkuysabor.databinding.FragmentHomeBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.mapAsync
import com.leandro1995.tinkuysabor.extension.registerForActivityLocationResult
import com.leandro1995.tinkuysabor.extension.viewLifecycleOwner
import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.intent.callback.action.HomeIntentActionCallBack
import com.leandro1995.tinkuysabor.intent.config.action.HomeIntentActionConfig
import com.leandro1995.tinkuysabor.model.design.Message
import com.leandro1995.tinkuysabor.util.GoogleMapUtil
import com.leandro1995.tinkuysabor.util.LocationUtil
import com.leandro1995.tinkuysabor.util.MessageUtil
import com.leandro1995.tinkuysabor.viewmodel.HomeViewModel

class HomeFragment : Fragment(), HomeIntentActionCallBack, OnMapReadyCallback {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var locationUtil: LocationUtil
    private lateinit var googleMapUtil: GoogleMapUtil
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

        mapAsync(fragmentManager = childFragmentManager, idMap = R.id.map).getMapAsync(this)

        return fragmentHomeBinding.root
    }

    @SuppressLint("MissingPermission")
    override fun view(view: HomeIntentAction) {
        fragmentHomeBinding.apply {
            locationLoadingViewComponent.visibleLoading(isVisible = view.locationLoading.isVisible)
            loadingViewComponent.start(loading = view.loading, method = {
                this@HomeFragment.homeViewModel.startService(idService = view.loading.idService)
            })
            loadingViewComponent.messageError(messageError = view.tourMessageError, buttonError = {
                this@HomeFragment.homeViewModel.action.invoke(HomeViewModel.TOURISM_LIST_LOADING)
            })
            MessageUtil.bottomSheetBehavior(
                view = bottomSheetFrameLayout,
                isVisible = view.isTourRouteBottomSheet,
                typeBottomSheetBehavior = BottomSheetBehavior.STATE_COLLAPSED
            )
            tourRecyclerView.let { recyclerView ->
                recyclerView.layoutManager = LinearLayoutManager(requireActivity()).apply {
                    orientation = LinearLayoutManager.VERTICAL
                }
                recyclerView.adapter =
                    TourBottomSheetAdapter(tourArrayList = view.tourArrayList).apply {
                        tourBottomSheetAdapterCallBack = object : TourBottomSheetAdapterCallBack {
                            override fun animateCamera(latLng: LatLng) {
                                googleMapUtil.animateCamera(latLng = latLng, isAddMarker = false)
                            }
                        }
                    }
            }
        }

        locationUtil.verifyLocation(isStart = view.isVerifyLocation, method = {
            homeViewModel.action.invoke(HomeViewModel.GPS_LOCATION)
        }, messageError = {
            locationLaunch.launch(it)
        })

        locationUtil.starLocation(
            isStart = view.isStartLocation, method = { latitude, longitude ->
                homeViewModel.personLocation(latLng = LatLng(latitude, longitude))
                homeViewModel.action.invoke(HomeViewModel.TOURISM_LIST_LOADING)
            })

        googleMapUtil.animateCamera(latLng = view.personLocation)
        googleMapUtil.marker(view.tourArrayList.map { it.latLng() })
    }

    override fun initView() {
        homeViewModel.action.invoke(HomeViewModel.VERIFY_GPS_LOCATION)
    }

    override fun onMapReady(p0: GoogleMap) {
        googleMapUtil = GoogleMapUtil(googleMap = p0)
        googleMapUtil.resetMap()

        viewLifecycleOwner {
            homeViewModel.intentActionStateFlow.collect { homeIntentAction ->
                HomeIntentActionConfig(
                    homeIntentAction = homeIntentAction, homeIntentActionCallBack = this
                )
            }
        }
    }

    override fun onDestroyView() {
        locationUtil.stopLocation()
        super.onDestroyView()
    }
}