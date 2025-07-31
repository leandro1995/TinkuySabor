package com.leandro1995.tinkuysabor.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.FragmentTourismListBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil

class TourismListFragment : Fragment() {

    private lateinit var fragmentTourismListBinding: FragmentTourismListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentTourismListBinding = bindingUtil(
            layoutId = R.layout.fragment_tourism_list,
            inflater = inflater,
            container = container
        )

        return fragmentTourismListBinding.root
    }
}