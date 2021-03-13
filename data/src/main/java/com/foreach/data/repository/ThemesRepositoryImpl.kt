package com.foreach.data.repository

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.foreach.data.dataservice.sqlservice.dao.RoomDao
import com.foreach.data.datastore.ThemesRepository
import com.foreach.entities.roommodel.ThemesEntity

class ThemesRepositoryImpl(private val roomDao: RoomDao) : ThemesRepository {


    override suspend fun insertThemes(themes : List<ThemesEntity>) {
        roomDao.insertThemes(themes)
    }


    override suspend fun insertTheme(theme : ThemesEntity) {
        roomDao.insertTheme(theme)
    }


    override suspend fun getThemes() : List<ThemesEntity> {
        return roomDao.getThemes()
    }
}