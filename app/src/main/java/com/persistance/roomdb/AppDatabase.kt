package com.persistance.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User_Entitiy::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun userDao(): User_Dao


    companion object {
        private var INSTANCE :AppDatabase?= null
        fun getDatabase(context:Context):AppDatabase?
        {
            if (INSTANCE == null)
            {
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java,
                        "userdb.db").build()
                }
            }
            return INSTANCE
        }
    }
}