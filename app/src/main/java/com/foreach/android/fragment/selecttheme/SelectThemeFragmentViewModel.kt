package com.foreach.android.fragment.selecttheme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.foreach.android.base.viewmodel.BaseViewModel
import com.foreach.domain.interactor.ThemesInteractor
import com.foreach.entities.roommodel.ThemesEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SelectThemeFragmentViewModel(private val themesInteractor: ThemesInteractor) : BaseViewModel() {


    private val _themesMutableLiveData = MutableLiveData<List<ThemesEntity>>()
    val themesMutableLiveData: LiveData<List<ThemesEntity>>
        get() = _themesMutableLiveData

    fun insertThemes(themes: List<ThemesEntity>){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                themesInteractor.insertThemes(themes)
            }
        }
    }

    fun insertTheme(theme: ThemesEntity){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                themesInteractor.insertTheme(theme)
            }
        }
    }

    fun getThemes() {
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                val listThemes = themesInteractor.getThemes()
                _themesMutableLiveData.value = listThemes
            }
        }
    }
}