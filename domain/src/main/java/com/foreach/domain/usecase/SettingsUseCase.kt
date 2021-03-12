package com.foreach.domain.usecase

import com.foreach.data.datastore.SettingsRepository
import com.foreach.domain.interactor.SettingsInteractor

class SettingsUseCase(private val settingsRepository: SettingsRepository) : SettingsInteractor {

    override fun getStringData(name : String) : String?{
        return settingsRepository.getStringData(name)
    }

    override fun setStringData(name : String, value : String) {
        settingsRepository.setStringData(name,value)
    }
}