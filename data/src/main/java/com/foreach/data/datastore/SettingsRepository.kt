package com.foreach.data.datastore

interface SettingsRepository {
    fun getStringData(name : String) : String?
    fun setStringData(name : String, value : String)
}