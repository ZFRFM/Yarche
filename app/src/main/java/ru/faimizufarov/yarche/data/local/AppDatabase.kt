package ru.faimizufarov.yarche.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NameEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun nameDao(): NameDao

    companion object {
        @Volatile
        private var databaseInstance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return databaseInstance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database",
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { databaseInstance = it }
            }
        }
    }
}
