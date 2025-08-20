package com.leandro1995.tinkuysabor.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.FragmentTourismListBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.viewLifecycleOwner
import com.leandro1995.tinkuysabor.intent.callback.TourismListIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.TourismListIntentConfig
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.design.Toolbar
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.viewmodel.TourismListViewModel

class TourismListFragment : Fragment(), TourismListIntentCallBack {

    private val tourismListViewModel by activityViewModels<TourismListViewModel>()

    private lateinit var fragmentTourismListBinding: FragmentTourismListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentTourismListBinding = bindingUtil(
            layoutId = R.layout.fragment_tourism_list, inflater = inflater, container = container
        )

        fragmentTourismListBinding.tourismListViewModel = tourismListViewModel

        viewLifecycleOwner {
            tourismListViewModel.intentActionMutableStateFlow.collect { tourismListIntentAction ->
                TourismListIntentConfig(
                    tourismListIntentAction = tourismListIntentAction,
                    tourismListIntentCallBack = this
                )
            }
        }

        tourismListViewModel.action.invoke(TourismListViewModel.INIT_VIEW)

        return fragmentTourismListBinding.root
    }

    override fun tourismArrayList(tourismArrayList: ArrayList<Tour>) {
        fragmentTourismListBinding.tourismListLoadingRecyclerViewComponent.setAdapter(arrayList = tourismArrayList)
    }

    override fun showLoading(loading: Loading) {
        fragmentTourismListBinding.tourismListLoadingRecyclerViewComponent.start(
            loading = loading,
            method = { tourismListViewModel.startService(idService = loading.idService) })
    }

    override fun messageError(idMessageError: Int) {
        fragmentTourismListBinding.tourismListLoadingRecyclerViewComponent.messageError(
            messageError = getString(idMessageError), buttonError = {
                tourismListViewModel.action.invoke(TourismListViewModel.TOURISM_LIST)
            })
    }

    override fun initView() {
        fragmentTourismListBinding.apply {
            Toolbar(
                materialToolbar = fragmentTourismListBinding.includeAppBar.toolbar,
                title = getString(R.string.list_tourist_places_text_title)
            ).create()
        }
    }
}