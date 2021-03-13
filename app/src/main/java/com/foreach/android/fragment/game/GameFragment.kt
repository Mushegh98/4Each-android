package com.foreach.android.fragment.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.foreach.android.R
import com.foreach.android.base.FragmentBaseMVVM
import com.foreach.android.base.utils.viewBinding
import com.foreach.android.databinding.FragmentGameBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class GameFragment : FragmentBaseMVVM<GameViewModel,FragmentGameBinding>() {


    override val viewModel by viewModel<GameViewModel>()
    override val binding by viewBinding<FragmentGameBinding>()

    companion object {
        @JvmStatic
        fun newInstance() = GameFragment()
    }

    override fun initView() {

    }

    override fun navigateUp() {

    }
}