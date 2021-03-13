package com.foreach.android.fragment.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.foreach.android.base.viewmodel.BaseViewModel
import com.foreach.domain.interactor.GameInteractor
import com.foreach.entities.roommodel.GameEntity
import com.foreach.entities.roommodel.ThemesEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GameViewModel(private val gameInteractor: GameInteractor) : BaseViewModel() {

    private val _gameData = MutableLiveData<List<GameEntity>>()
    val gameData: LiveData<List<GameEntity>>
        get() = _gameData


    fun getStringData(name : String) : String?{
        return gameInteractor.getStringData(name)
    }

    fun setStringData(name : String, value : String) {
        gameInteractor.setStringData(name,value)
    }

    fun getGameData(title : String) {
        viewModelScope.launch {
            val gameData = gameInteractor.getGameData(title)
            withContext(Dispatchers.Main){
                _gameData.value = gameData
            }
        }
    }

    fun clearTeamPoints(){
        gameInteractor.clearTeamPoints()
    }
}