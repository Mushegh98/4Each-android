package com.foreach.android.fragment

import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.viewBinding
import com.foreach.android.databinding.FragmentSelectTeamsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectTeamsFragment : FragmentBaseMVVM<SelectTeamsFragmentViewModel, FragmentSelectTeamsBinding>() {


// class StartFragment : FragmentBaseMVVM<StartFragmentViewModel,FragmentStartBinding>() {


    override val viewModel by viewModel<SelectTeamsFragmentViewModel>()
    override val binding by viewBinding<FragmentSelectTeamsBinding>()
    companion object {
        @JvmStatic
        fun newInstance() = SelectTeamsFragment()
    }
    override fun initView() {
    }

    override fun navigateUp() {
        navigateBackStack()
    }

    override fun initViewClickListeners() {
        with(binding) {
            nextBtn.setOnClickListener {
                //TODO("nextBtn onClick")
            }
        }
    }

    override fun observes() {
    }
}