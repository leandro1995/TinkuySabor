package com.leandro1995.tinkuysabor.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.FragmentProfileBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil

class ProfileFragment : Fragment() {

    private lateinit var fragmentProfileBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentProfileBinding = bindingUtil(
            layoutId = R.layout.fragment_profile, inflater = inflater, container = container
        )

        return fragmentProfileBinding.root
    }
}