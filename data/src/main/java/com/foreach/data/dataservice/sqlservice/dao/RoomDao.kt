package com.foreach.data.dataservice.sqlservice.dao

import androidx.room.*
import com.foreach.entities.roommodel.ThemesEntity

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThemes(themes : List<ThemesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTheme(theme : ThemesEntity)

    @Query("SELECT * FROM Themes")
    suspend fun getThemes() : List<ThemesEntity>
}