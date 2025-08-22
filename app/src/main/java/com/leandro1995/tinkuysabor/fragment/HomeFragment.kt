package com.leandro1995.tinkuysabor.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.FragmentHomeBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil

class HomeFragment : Fragment() {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentHomeBinding = bindingUtil(
            layoutId = R.layout.fragment_home, inflater = inflater, container = container
        )

        return fragmentHomeBinding.root
    }
}