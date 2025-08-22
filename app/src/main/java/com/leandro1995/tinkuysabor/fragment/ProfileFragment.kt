package com.leandro1995.tinkuysabor.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.activity.LoginActivity
import com.leandro1995.tinkuysabor.databinding.FragmentProfileBinding
import com.leandro1995.tinkuysabor.extension.bindingUtil
import com.leandro1995.tinkuysabor.extension.viewLifecycleOwner
import com.leandro1995.tinkuysabor.intent.config.event.ProfileIntentEventConfig
import com.leandro1995.tinkuysabor.intent.event.ProfileIntentEvent
import com.leandro1995.tinkuysabor.intent.event.config.callback.ProfileIntentEventCallBack
import com.leandro1995.tinkuysabor.model.design.Toolbar
import com.leandro1995.tinkuysabor.viewmodel.ProfileViewModel

class ProfileFragment : Fragment(), ProfileIntentEventCallBack {

    private val profileViewModel by viewModels<ProfileViewModel>()

    private lateinit var fragmentProfileBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        fragmentProfileBinding = bindingUtil(
            layoutId = R.layout.fragment_profile, inflater = inflater, container = container
        )
        fragmentProfileBinding.profileViewModel = profileViewModel

        Toolbar(
            materialToolbar = fragmentProfileBinding.includeAppBar.toolbar,
            title = getString(R.string.profile_text_title)
        ).create()

        viewLifecycleOwner {
            profileViewModel.intentEventSharedFlow.collect { profileIntentEvent ->
                ProfileIntentEventConfig(
                    profileIntentEvent = profileIntentEvent, profileIntentEventCallBack = this
                )
            }
        }

        return fragmentProfileBinding.root
    }

    override fun startLoginActivity() {
        startActivity(Intent(requireActivity(), LoginActivity::class.java))
        requireActivity().finishAffinity()
    }
}