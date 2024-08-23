package com.example.autogestion.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "reparation_table",
    foreignKeys = [ForeignKey(
        entity = Vehicle::class,
        parentColumns = ["vehicleId"],
        childColumns = ["vehicleId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Reparation(
    @PrimaryKey(autoGenerate = true)
    val reparationId: Int,
    val vehicleId: Int,
    val description: String,
    val date: String,
    val invoice: String,
    val paid : Boolean,
)
