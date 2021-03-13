package com.foreach.android.fragment.startFragment

import android.os.Bundle
import android.view.View
import com.foreach.android.base.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.foreach.android.R
import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.extension.addFragment
import com.foreach.android.databinding.FragmentStartBinding
import com.foreach.android.fragment.aboutGame.AboutGameFragment
import com.foreach.android.fragment.selectTeams.SelectTeamsFragment
import com.foreach.android.fragment.settings.SettingsFragment
import com.foreach.entities.roommodel.ThemesEntity

class StartFragment : FragmentBaseMVVM<StartFragmentViewModel,FragmentStartBinding>() {

    override val viewModel by viewModel<StartFragmentViewModel>()
    override val binding by viewBinding<FragmentStartBinding>()


    companion object {
        fun newInstance(): StartFragment {
            return StartFragment()
        }
    }

    @ExperimentalStdlibApi
    override fun initView() {
        if(viewModel.getStringData("room").isNullOrEmpty()){
            val listEntity = buildList<ThemesEntity> {
                add(ThemesEntity("https://s3-eu-west-1.amazonaws.com/uploads.playbaamboozle.com/uploads/images/82626/1594704748_77856","Football"))
            }
            viewModel.insertThemes(listEntity)
            viewModel.setStringData("room","room")

        }else{

        }
    }

    override fun navigateUp() {
        activity?.finish()
    }

    override fun initViewClickListeners() {
        with(binding){
            btnStartGame.setOnClickListener {
                activity?.supportFragmentManager?.addFragment(R.id.frame,SelectTeamsFragment.newInstance())
            }
            btnSettings.setOnClickListener {
                activity
                    ?.supportFragmentManager?.addFragment(
                        R.id.frame,
                        SettingsFragment.newInstance()
                    )
            }
            btnAboutTheGame.setOnClickListener {
                activity?.supportFragmentManager?.addFragment(R.id.frame,AboutGameFragment.newInstance())
            }
        }

    }
}