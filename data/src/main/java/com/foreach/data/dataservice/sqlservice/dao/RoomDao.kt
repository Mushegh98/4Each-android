package com.foreach.data.dataservice.sqlservice.dao

import androidx.room.*
import com.foreach.entities.roommodel.GameEntity
import com.foreach.entities.roommodel.ThemesEntity

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertThemes(themes : List<ThemesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTheme(theme : ThemesEntity)

    @Query("SELECT * FROM Themes")
    suspend fun getThemes() : List<ThemesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameAllData(gameAllData  : List<GameEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameData(gameData : GameEntity)

    @Query("SELECT * FROM Game")
    suspend fun getGameData() : List<GameEntity>

    @Query("SELECT * FROM Game WHERE type = :title")
    suspend fun getGameData(title : String) : List<GameEntity>
}