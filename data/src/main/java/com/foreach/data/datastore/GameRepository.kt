package com.foreach.data.datastore

import com.foreach.entities.roommodel.GameEntity

interface GameRepository {
    fun getStringData(name : String) : String?
    fun setStringData(name : String, value : String)
    suspend fun getGameData(title : String) : List<GameEntity>
}