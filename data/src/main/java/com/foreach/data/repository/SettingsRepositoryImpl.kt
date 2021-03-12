package com.foreach.data.repository

import com.foreach.data.dataservice.appservice.PreferenceService
import com.foreach.data.datastore.SettingsRepository

class SettingsRepositoryImpl(private val preferenceService: PreferenceService) : SettingsRepository {

    override fun getStringData(name : String) : String?{
        return preferenceService.getStringData(name)
    }

    override fun setStringData(name : String, value : String) {
         preferenceService.setStringData(name,value)
    }

}