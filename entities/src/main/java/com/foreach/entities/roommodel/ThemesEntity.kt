package com.foreach.entities.roommodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Themes")
data class ThemesEntity(
    @PrimaryKey
    @SerializedName("url")
    var url : String,
    @SerializedName("title")
    var title : String

)