package com.foreach.domain.usecase

import com.foreach.data.datastore.GameRepository
import com.foreach.domain.interactor.GameInteractor
import com.foreach.entities.roommodel.GameEntity

class GameUseCase(private val gameRepository: GameRepository) : GameInteractor {

    override fun getStringData(name : String) : String?{
        return gameRepository.getStringData(name)
    }

    override fun setStringData(name : String, value : String) {
        gameRepository.setStringData(name,value)
    }

    override suspend fun getGameData(title : String) : List<GameEntity>{
        return gameRepository.getGameData(title)
    }

    override fun clearTeamPoints(){
        gameRepository.clearTeamPoints()
    }
}