package com.leandro1995.tinkuysabor.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.FragmentProfileBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.viewLifecycleOwner
import com.leandro1995.tinkuysabor.intent.callback.ProfileIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.ProfileIntentConfig
import com.leandro1995.tinkuysabor.model.design.Toolbar
import com.leandro1995.tinkuysabor.viewmodel.ProfileViewModel

class ProfileFragment : Fragment(), ProfileIntentCallBack {

    private val profileViewModel by viewModels<ProfileViewModel>()

    private lateinit var fragmentProfileBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentProfileBinding = bindingUtil(
            layoutId = R.layout.fragment_profile, inflater = inflater, container = container
        )

        viewLifecycleOwner {
            profileViewModel.profileIntentAction.collect { profileIntentAction ->
                ProfileIntentConfig(
                    profileIntentAction = profileIntentAction, profileIntentCallBack = this
                )
            }
        }

        return fragmentProfileBinding.root
    }

    override fun initView() {
        fragmentProfileBinding.apply {
            Toolbar(
                activity = requireActivity(),
                materialToolbar = includeAppBar.toolbar,
                idTitle = R.string.profile_text_title
            ).create()
        }
    }
}