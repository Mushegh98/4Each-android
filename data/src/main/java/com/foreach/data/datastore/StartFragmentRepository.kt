package com.foreach.data.datastore

import com.foreach.entities.roommodel.ThemesEntity

interface StartFragmentRepository {
    fun getStringData(name : String) : String?
    fun setStringData(name: String, value : String)
    suspend fun insertThemes(themesEntity: List<ThemesEntity>)
}