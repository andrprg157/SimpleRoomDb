package com.persistance.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User_Entitiy (
    @PrimaryKey(autoGenerate = true)
    val userId:Int,
    val name :String?,
    val phone :String?,
    )