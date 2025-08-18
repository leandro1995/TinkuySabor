package com.leandro1995.tinkuysabor.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.FragmentHomeBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.viewLifecycleOwner
import com.leandro1995.tinkuysabor.intent.callback.HomeIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.HomeIntentConfig
import com.leandro1995.tinkuysabor.viewmodel.HomeViewModel

class HomeFragment : Fragment(), HomeIntentCallBack {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()

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

    }
}