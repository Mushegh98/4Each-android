package com.foreach.android.di

import com.foreach.android.fragment.startFragment.StartFragmentViewModel
import com.foreach.android.fragment.aboutGame.AboutGameViewModel
import com.foreach.android.fragment.game.GameViewModel
import com.foreach.android.fragment.selecttheme.SelectThemeFragmentViewModel
import com.foreach.android.fragment.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SettingsViewModel(get()) }
    viewModel { StartFragmentViewModel(get()) }
    viewModel { AboutGameViewModel() }
    viewModel { SelectThemeFragmentViewModel(get()) }
    viewModel { GameViewModel(get()) }
}