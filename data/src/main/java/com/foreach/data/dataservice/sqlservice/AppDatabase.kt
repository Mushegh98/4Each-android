package com.foreach.data.dataservice.sqlservice

import androidx.room.Database
import androidx.room.RoomDatabase
import com.foreach.data.dataservice.sqlservice.dao.RoomDao
import com.foreach.entities.roommodel.GameEntity
import com.foreach.entities.roommodel.TestEntity
import com.foreach.entities.roommodel.ThemesEntity

@Database(
        entities = [TestEntity::class, GameEntity::class, ThemesEntity::class],
        version = 3,
        exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun roomDao(): RoomDao
}