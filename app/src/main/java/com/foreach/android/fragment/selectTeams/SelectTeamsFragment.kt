package com.foreach.android.fragment.selectTeams

import android.os.Bundle
import com.foreach.android.R
import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.extension.addFragment
import com.foreach.android.base.utils.extension.replaceFragment
import com.foreach.android.base.utils.viewBinding
import com.foreach.android.databinding.FragmentSelectTeamsBinding
import com.foreach.android.fragment.selecttheme.SelectThemeFragmentFragment
import kotlinx.android.synthetic.main.activity_main.view.*
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
                val bundle = Bundle().apply {
                    putString("command1",binding.editTeam1Titles.text.toString())
                    putString("command2",binding.editTeam2Titles.text.toString())
                }
                activity?.supportFragmentManager?.replaceFragment(R.id.frame,SelectThemeFragmentFragment.newInstance(bundle))
            }
            backBtn.setOnClickListener {
                navigateBackStack()
            }
        }
    }

    override fun observes() {
    }
}