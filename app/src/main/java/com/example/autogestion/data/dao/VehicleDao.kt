package com.example.autogestion.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.autogestion.data.Vehicle

@Dao
interface VehicleDao {
    // Inserer un véhicule
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVehicle(vehicle: Vehicle)

    // Modifier un véhicule
    @Update
    suspend fun updateVehicle(vehicle: Vehicle)

    // Supprimer un véhicule
    @Delete
    suspend fun deleteVehicle(vehicle: Vehicle)

    // Obtenir un véhicule
    @Query("SELECT * FROM vehicle_table WHERE vehicleId = :vehicleId")
    suspend fun getVehicleById(vehicleId: Int): Vehicle?

    // Obtenir tous les véhicules
    @Query("SELECT * FROM vehicle_table")
    suspend fun getAllVehicles(): List<Vehicle>
}
