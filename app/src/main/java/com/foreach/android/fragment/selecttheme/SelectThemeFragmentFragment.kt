package com.foreach.android.fragment.selecttheme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.foreach.android.R
import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.viewBinding
import com.foreach.android.databinding.FragmentSelectThemeFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectThemeFragmentFragment(private val bundle: Bundle) : FragmentBaseMVVM<SelectThemeFragmentViewModel,FragmentSelectThemeFragmentBinding>() {


    override val viewModel by viewModel<SelectThemeFragmentViewModel>()
    override val binding by viewBinding<FragmentSelectThemeFragmentBinding>()


    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) = SelectThemeFragmentFragment(bundle)
    }

    override fun initView() {

    }

    override fun navigateUp() {
        navigateBackStack()
    }
}