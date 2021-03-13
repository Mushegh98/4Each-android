package com.foreach.domain.interactor

import com.foreach.entities.roommodel.ThemesEntity

interface ThemesInteractor {

    suspend fun insertThemes(themes: List<ThemesEntity>)

    suspend fun insertTheme(theme: ThemesEntity)

    suspend fun getThemes(): List<ThemesEntity>
}