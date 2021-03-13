package com.foreach.data.datastore

import com.foreach.entities.roommodel.ThemesEntity

interface ThemesRepository {

    suspend fun insertThemes(themes: List<ThemesEntity>)

    suspend fun insertTheme(theme: ThemesEntity)

    suspend fun getThemes(): List<ThemesEntity>
}