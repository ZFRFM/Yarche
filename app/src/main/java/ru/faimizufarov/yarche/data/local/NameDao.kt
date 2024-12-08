package ru.faimizufarov.yarche.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NameDao {
    @Query("SELECT * FROM name WHERE id= :id")
    suspend fun getName(id: Int): NameEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertName(nameEntity: NameEntity)

    @Query("SELECT COUNT(*) FROM name")
    suspend fun checkNamePresence(): Int
}