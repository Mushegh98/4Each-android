package com.foreach.data.repository

import com.foreach.data.dataservice.appservice.PreferenceService
import com.foreach.data.dataservice.sqlservice.dao.RoomDao
import com.foreach.data.datastore.StartFragmentRepository
import com.foreach.entities.roommodel.GameEntity
import com.foreach.entities.roommodel.ThemesEntity

class StartFragmentRepositoryImpl(private val preferenceService: PreferenceService, private val roomDao: RoomDao) : StartFragmentRepository {

    override fun getStringData(name : String) = preferenceService.getStringData(name)

    override fun setStringData(name: String, value : String) {
        preferenceService.setStringData(name,value)
    }

    override suspend fun insertThemes(themesEntity: List<ThemesEntity>)  {
        roomDao.insertThemes(themesEntity)
    }

    override suspend fun insertGameAllData(gameData : List<GameEntity>)  {
        roomDao.insertGameAllData(gameData)
    }
}