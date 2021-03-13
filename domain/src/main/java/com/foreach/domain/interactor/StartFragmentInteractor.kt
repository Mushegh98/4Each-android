package com.foreach.domain.interactor

import com.foreach.entities.roommodel.ThemesEntity

interface StartFragmentInteractor {
    fun getStringData(name : String) : String?
    fun setStringData(name: String, value : String)
    suspend fun insertThemes(themesEntity: List<ThemesEntity>)
}