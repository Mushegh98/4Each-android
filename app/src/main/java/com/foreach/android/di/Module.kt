package com.foreach.android.di

import com.foreach.android.fragment.SettingsFragment
import com.foreach.android.fragment.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SettingsViewModel(get()) }

}