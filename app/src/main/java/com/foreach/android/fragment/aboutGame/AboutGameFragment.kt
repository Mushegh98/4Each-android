package com.foreach.android.fragment.aboutGame

import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.viewBinding
import com.foreach.android.databinding.FragmentAboutGameBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AboutGameFragment : FragmentBaseMVVM<AboutGameViewModel,FragmentAboutGameBinding>() {

    override val viewModel by viewModel<AboutGameViewModel>()
    override val binding by viewBinding<FragmentAboutGameBinding>()


    companion object {
        @JvmStatic
        fun newInstance() = AboutGameFragment()
    }

    override fun initView() {

    }

    override fun navigateUp() {
        navigateBackStack()
    }

    override fun initViewClickListeners() {
        with(binding){
            backBtn.setOnClickListener {
                navigateBackStack()
            }
        }
    }

    override fun observes() {

    }
}