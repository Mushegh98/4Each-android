package com.foreach.android.fragment.startFragment

import androidx.lifecycle.viewModelScope
import com.foreach.android.base.viewmodel.BaseViewModel
import com.foreach.domain.interactor.StartFragmentInteractor
import com.foreach.entities.roommodel.ThemesEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StartFragmentViewModel(private val startFragmentInteractor: StartFragmentInteractor) : BaseViewModel() {

    fun getStringData(name : String) = startFragmentInteractor.getStringData(name)

    fun insertThemes(themesEntity: List<ThemesEntity>) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                startFragmentInteractor.insertThemes(themesEntity)
            }
        }
    }

    fun setStringData(name: String, value : String) {
        startFragmentInteractor.setStringData(name,value)
    }
}