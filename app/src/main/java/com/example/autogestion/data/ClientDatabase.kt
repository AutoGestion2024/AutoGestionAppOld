package com.example.autogestion.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Client::class, Vehicle::class, Reparation::class], version = 1, exportSchema = false)
abstract class ClientDatabase : RoomDatabase() {

    abstract fun clientDao(): ClientDao

    companion object {
        @Volatile
        private var INSTANCE: ClientDatabase? = null
    }
}
