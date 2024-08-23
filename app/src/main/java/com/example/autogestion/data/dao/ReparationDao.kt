package com.example.autogestion.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.autogestion.data.Reparation

@Dao
interface ReparationDao {
    // Inserer une reparation
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addReparation(reparation: Reparation)

    // Modifier une réparation
    @Update
    suspend fun updateReparation(reparation: Reparation)

    // Supprimer une réparation
    @Delete
    suspend fun deleteReparation(reparation: Reparation)

    // Obtenir une réparation
    @Query("SELECT * FROM reparation_table WHERE reparationId = :reparationId")
    suspend fun getReparationById(reparationId: Int): Reparation?

    // Obtenir toutes les réparations
    @Query("SELECT * FROM reparation_table")
    suspend fun getAllReparations(): List<Reparation>
}