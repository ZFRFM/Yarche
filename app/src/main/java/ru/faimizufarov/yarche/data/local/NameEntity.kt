package ru.faimizufarov.yarche.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "name")
data class NameEntity(
    @PrimaryKey val id: String,
    @ColumnInfo("name") val name: String
)