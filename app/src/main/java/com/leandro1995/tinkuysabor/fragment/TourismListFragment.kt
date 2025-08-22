package com.leandro1995.tinkuysabor.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.FragmentTourismListBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.viewLifecycleOwner
import com.leandro1995.tinkuysabor.intent.action.TourismListIntentAction
import com.leandro1995.tinkuysabor.intent.callback.action.TourismListIntentActionCallBack
import com.leandro1995.tinkuysabor.intent.config.action.TourismListIntentActionConfig
import com.leandro1995.tinkuysabor.model.design.Toolbar
import com.leandro1995.tinkuysabor.viewmodel.TourismListViewModel

class TourismListFragment : Fragment(), TourismListIntentActionCallBack {

    private lateinit var fragmentTourismListBinding: FragmentTourismListBinding
    private val tourismListViewModel by navGraphViewModels<TourismListViewModel>(R.id.home_navigation)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentTourismListBinding = bindingUtil(
            layoutId = R.layout.fragment_tourism_list, inflater = inflater, container = container
        )
        fragmentTourismListBinding.tourismListViewModel = tourismListViewModel

        Toolbar(
            materialToolbar = fragmentTourismListBinding.includeAppBar.toolbar,
            title = getString(R.string.list_tourist_places_text_title)
        ).create()

        viewLifecycleOwner {
            tourismListViewModel.intentActionStateFlow.collect { tourismListIntentAction ->
                TourismListIntentActionConfig(
                    tourismListIntentAction = tourismListIntentAction,
                    tourismListIntentActionCallBack = this
                )
            }
        }

        return fragmentTourismListBinding.root
    }

    override fun view(view: TourismListIntentAction) {
        fragmentTourismListBinding.apply {
            tourismListLoadingRecyclerViewComponent.start(loading = view.loading, method = {
                this@TourismListFragment.tourismListViewModel.startService(idService = view.loading.idService)
            })

            tourismListLoadingRecyclerViewComponent.setAdapter(arrayList = view.tourArrayList)

            tourismListLoadingRecyclerViewComponent.messageError(
                messageError = view.message, buttonError = {
                    this@TourismListFragment.tourismListViewModel.action.invoke(TourismListViewModel.TOURISM_LIST_LOADING)
                })
        }
    }

    override fun initView() {
        tourismListViewModel.action.invoke(TourismListViewModel.TOURISM_LIST_LOADING)
    }
}