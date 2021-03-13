package com.foreach.android.fragment.settings

import com.foreach.android.base.viewmodel.BaseViewModel
import com.foreach.domain.interactor.SettingsInteractor

class SettingsViewModel(private val settingsInteractor: SettingsInteractor) : BaseViewModel() {

    fun getStringData(name : String) : String?{
        return settingsInteractor.getStringData(name)
    }

    fun setStringData(name : String, value : String) {
        settingsInteractor.setStringData(name,value)
    }
}