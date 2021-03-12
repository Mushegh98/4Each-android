package com.foreach.domain.interactor

interface SettingsInteractor {
    fun getStringData(name : String) : String?
    fun setStringData(name : String, value : String)
}