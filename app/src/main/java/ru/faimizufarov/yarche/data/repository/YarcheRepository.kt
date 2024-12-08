package ru.faimizufarov.yarche.data.repository

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.faimizufarov.yarche.data.local.AppDatabase
import ru.faimizufarov.yarche.data.local.NameEntity
import ru.faimizufarov.yarche.data.models.Name

class YarcheRepository(
    private val context: Context
) {
    private val database = AppDatabase.getDatabase(context)

    suspend fun getUserName() =
        withContext(Dispatchers.IO) {
            database.nameDao().getName(0)
        }

    suspend fun updateUserName(name: Name) =
        withContext(Dispatchers.IO) {
            database.nameDao().insertName(name.toNameEntity())
        }

    suspend fun checkNamePresence() =
        withContext(Dispatchers.IO) {
            if (database.nameDao().checkNamePresence() == 0) false else true
        }

    private fun Name.toNameEntity() =
        NameEntity(
            id = id,
            name = name
        )

    private fun NameEntity.toName() =
        Name(
            id = id,
            name = name
        )
}