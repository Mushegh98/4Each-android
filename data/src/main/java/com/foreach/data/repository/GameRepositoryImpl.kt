package com.foreach.data.repository

import com.foreach.data.dataservice.appservice.PreferenceService
import com.foreach.data.dataservice.sqlservice.dao.RoomDao
import com.foreach.data.datastore.GameRepository
import com.foreach.entities.roommodel.GameEntity

class GameRepositoryImpl(private val preferenceService: PreferenceService, private val roomDao: RoomDao) : GameRepository {

    override fun getStringData(name : String) : String?{
        return preferenceService.getStringData(name)
    }

    override fun setStringData(name : String, value : String) {
        preferenceService.setStringData(name,value)
    }

    override suspend fun getGameData(title : String) : List<GameEntity>{
        return roomDao.getGameData(title)
    }
}