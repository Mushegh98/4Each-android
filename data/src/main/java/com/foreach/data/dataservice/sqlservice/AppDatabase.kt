package com.foreach.data.dataservice.sqlservice

import androidx.room.Database
import androidx.room.RoomDatabase
import com.foreach.data.dataservice.sqlservice.dao.RoomDao
import com.foreach.entities.roommodel.TestEntity

@Database(
        entities = [TestEntity::class],
        version = 1,
        exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun roomDao(): RoomDao
}