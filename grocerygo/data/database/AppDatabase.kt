package com.example.grocerygo.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CartEntity::class],
    version = 1
)

abstract class AppDatabase :
    RoomDatabase() {

    abstract fun cartDao(): CartDao

    companion object {

        private var INSTANCE:
                AppDatabase? = null

        fun getDatabase(
            context: Context
        ): AppDatabase {

            if (INSTANCE == null) {

                INSTANCE =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "grocery_database"
                    ).build()
            }

            return INSTANCE!!
        }
    }
}