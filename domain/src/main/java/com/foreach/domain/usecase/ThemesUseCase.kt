package com.foreach.domain.usecase

import com.foreach.data.datastore.ThemesRepository
import com.foreach.domain.interactor.ThemesInteractor
import com.foreach.entities.roommodel.ThemesEntity

class ThemesUseCase(private val themesRepository: ThemesRepository) : ThemesInteractor {

    override suspend fun insertThemes(themes : List<ThemesEntity>) = themesRepository.insertThemes(themes)


    override suspend fun insertTheme(theme : ThemesEntity) = themesRepository.insertTheme(theme)


    override suspend fun getThemes() : List<ThemesEntity> = themesRepository.getThemes()
}