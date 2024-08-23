package com.example.autogestion.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface ClientDao {

    // Clients
    // Inserer un client
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addClient(client: Client)

    // Modifier un client
    @Update
    suspend fun updateClient(client: Client)

    // Supprimer un client
    @Delete
    suspend fun deleteClient(client: Client)

    // Obtenir un client
    @Query("SELECT * FROM client_table WHERE clientId = :clientId")
    suspend fun getClientById(clientId: Int): Client?

    // Obtenir tous les clients
    @Query("SELECT * FROM client_table")
    suspend fun getAllClients(): List<Client>


    // Véhicules
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


    // Réparations
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

    // Obtenir un client avec ses véhicules
    @Transaction
    @Query("SELECT * FROM client_table WHERE clientId = :clientId")
    suspend fun getClientWithVehicles(clientId: Int): List<ClientWithVehicles>

    // Obtenir un véhicule avec ses réparations
    @Transaction
    @Query("SELECT * FROM vehicle_table WHERE vehicleId = :vehicleId")
    suspend fun getVehicleWithReparations(vehicleId: Int): List<VehicleWithReparations>
}
