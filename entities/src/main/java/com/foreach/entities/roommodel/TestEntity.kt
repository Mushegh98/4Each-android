package com.foreach.entities.roommodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int
)


