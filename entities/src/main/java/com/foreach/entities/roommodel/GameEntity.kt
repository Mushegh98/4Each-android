package com.foreach.entities.roommodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class GameEntity(
    @PrimaryKey
    @SerializedName("url")
    var url : String
)