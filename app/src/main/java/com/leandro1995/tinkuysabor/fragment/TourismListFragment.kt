package com.leandro1995.tinkuysabor.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navGraphViewModels
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.FragmentTourismListBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.viewLifecycleOwner
import com.leandro1995.tinkuysabor.model.design.Toolbar
import com.leandro1995.tinkuysabor.viewmodel.TourismListViewModel
import kotlinx.coroutines.launch

class TourismListFragment : Fragment() {

    private lateinit var fragmentTourismListBinding: FragmentTourismListBinding
    private val tourismListViewModel by navGraphViewModels<TourismListViewModel>(R.navigation.home_navigation)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentTourismListBinding = bindingUtil(
            layoutId = R.layout.fragment_tourism_list, inflater = inflater, container = container
        )

        Toolbar(
            materialToolbar = fragmentTourismListBinding.includeAppBar.toolbar,
            title = getString(R.string.list_tourist_places_text_title)
        ).create()

        viewLifecycleOwner {
            tourismListViewModel.intentActionStateFlow.collect { tourismListIntentAction ->

            }
        }

        viewLifecycleOwner {
            tourismListViewModel.intentEventSharedFlow.collect { tourismListIntentEvent -> }
        }

        return fragmentTourismListBinding.root
    }
}