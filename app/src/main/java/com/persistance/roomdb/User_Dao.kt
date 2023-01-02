package com.persistance.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface User_Dao {

    @Query("SELECT * FROM User_Entitiy")
    fun getAllUsers():List<User_Entitiy>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertUser(user: User_Entitiy) : Long

}