package com.leandro1995.tinkuysabor.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
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
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.util.GoogleMapUtil
import com.leandro1995.tinkuysabor.util.LocationUtil
import com.leandro1995.tinkuysabor.viewmodel.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    //private val homeViewModel by navGraphViewModels<HomeViewModel>(R.navigation.home_navigation)
    private val locationResult = registerForActivityLocationResult(method = {

    })
    private lateinit var locationUtil: LocationUtil
    private lateinit var googleMapUtil: GoogleMapUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locationUtil = LocationUtil(activity = requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentHomeBinding = bindingUtil(
            layoutId = R.layout.fragment_home, inflater = inflater, container = container
        )

        //mapAsync(fragmentManager = childFragmentManager, idMap = R.id.map).getMapAsync(this)

        return fragmentHomeBinding.root
    }

    /* override fun initView() {
        homeViewModel.action.invoke(HomeViewModel.VERIFY_LOCATION)
    }

    override fun onMapReady(p0: GoogleMap) {
        googleMapUtil = GoogleMapUtil(googleMap = p0)

        viewLifecycleOwner {
            /*homeViewModel.intentActionMutableStateFlow.collect { homeIntentAction ->
                HomeIntentConfig(homeIntentAction = homeIntentAction, homeIntentCallBack = this)
            }*/
        }

        homeViewModel.action.invoke(HomeViewModel.INIT_VIEW)
    }

    override fun loadingLocation(loading: Loading) {
        fragmentHomeBinding.locationLoadingViewComponent.visibleLoading(isVisible = loading.isVisible)
    }

    override fun verifyLocation() {
        locationUtil.verifyLocation(method = {
            homeViewModel.action.invoke(HomeViewModel.START_LOCATION)
        }, messageError = {
            locationResult.launch(it)
        })
    }

    @SuppressLint("MissingPermission")
    override fun startLocation() {
        locationUtil.starLocation { latitude, longitude ->
            homeViewModel.personalLatLng = LatLng(latitude, longitude)
            homeViewModel.action.invoke(HomeViewModel.TOURISM_LIST)
        }
    }

    override fun addMarkerPersonnelTourism(
        personalLatLng: LatLng, tourismArrayList: ArrayList<Tour>
    ) {
        googleMapUtil.apply {
            animateCamera(latLng = personalLatLng)
            marker(latLngList = tourismArrayList.map { it.latLng() })
        }
    }

    override fun showLoading(loading: Loading) {
        fragmentHomeBinding.loadingViewComponent.start(loading = loading, method = {
            homeViewModel.startService(idService = loading.idService)
        })
    }

    override fun messageError(idMessageError: Int) {
        fragmentHomeBinding.loadingViewComponent.messageError(
            messageError = getString(
                idMessageError
            ), buttonError = {
                homeViewModel.action.invoke(HomeViewModel.TOURISM_LIST)
            })
    }

    override fun onDestroyView() {
        locationUtil.stopLocation()
        super.onDestroyView()
    }*/
}