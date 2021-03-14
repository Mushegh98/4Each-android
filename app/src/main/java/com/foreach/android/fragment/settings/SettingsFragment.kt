package com.foreach.android.fragment.settings

import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.viewBinding
import com.foreach.android.databinding.FragmentSettingsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : FragmentBaseMVVM<SettingsViewModel,FragmentSettingsBinding>() {

    override val viewModel by viewModel<SettingsViewModel>()
    override val binding by viewBinding<FragmentSettingsBinding>()

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }

    override fun initView() {
        if(viewModel.getStringData("time").isNullOrEmpty()){
            viewModel.setStringData("time","1")
            viewModel.setStringData("points","15")
        }else{
            with(binding){
                timePoint.text = viewModel.getStringData("time")
                scorePoint.text = viewModel.getStringData("points")
            }
        }
    }

    override fun navigateUp() {
        navigateBackStack()
    }

    override fun initViewClickListeners() {
        with(binding){
            btnMinusScore.setOnClickListener {
                if(scorePoint.text.toString().toInt() == 15){
                    //Do nothing
                }else{
                    val points = (scorePoint.text.toString().toInt() - 1).toString()
                    scorePoint.text = points
                    viewModel.setStringData("points",points)
                }
            }
            btnPlusScore.setOnClickListener {
                val points = (scorePoint.text.toString().toInt() + 1).toString()
                scorePoint.text = points
                viewModel.setStringData("points",points)
            }
            btnMinusTime.setOnClickListener {
                if(timePoint.text.toString().toInt() == 1){
                    //Do nothing
                }else{
                    val time = (timePoint.text.toString().toInt() - 1).toString()
                    timePoint.text = time
                    viewModel.setStringData("time",time)
                }
            }
            btnPlusTime.setOnClickListener {
                val time = (timePoint.text.toString().toInt() + 1).toString()
                timePoint.text = time
                viewModel.setStringData("time",time)
            }
            backBtn.setOnClickListener {
                navigateBackStack()
            }
        }
    }

    override fun observes() {

    }
}