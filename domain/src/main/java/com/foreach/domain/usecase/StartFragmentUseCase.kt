package com.foreach.domain.usecase

import com.foreach.data.datastore.StartFragmentRepository
import com.foreach.domain.interactor.StartFragmentInteractor
import com.foreach.entities.roommodel.ThemesEntity

class StartFragmentUseCase(private val startFragmentRepository: StartFragmentRepository) : StartFragmentInteractor {

    override fun getStringData(name : String) = startFragmentRepository.getStringData(name)

    override fun setStringData(name: String, value : String) {
        startFragmentRepository.setStringData(name,value)
    }

    override suspend fun insertThemes(themesEntity: List<ThemesEntity>) = startFragmentRepository.insertThemes(themesEntity)
}