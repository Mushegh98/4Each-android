package com.foreach.domain.interactor

import com.foreach.entities.roommodel.GameEntity

interface GameInteractor {
    fun getStringData(name : String) : String?
    fun setStringData(name : String, value : String)
    suspend fun getGameData(title : String) : List<GameEntity>
    fun clearTeamPoints()
}