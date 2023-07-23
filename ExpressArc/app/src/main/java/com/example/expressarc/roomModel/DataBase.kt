package com.example.expressarc.roomModel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Calc::class], version = 1)
abstract class DataBase: RoomDatabase() {

    abstract fun calcDao(): Calc

    companion object {

        private var INSTANCE: DataBase? = null

        fun getDataBase(context: Context): DataBase {
            return if (INSTANCE == null) {
                synchronized(this) {
                    Room.databaseBuilder(
                        context,
                        DataBase::class.java,
                        "fitness_tracker"
                    )
                    .build()
                }
                INSTANCE as DataBase
            } else {
                INSTANCE as DataBase
            }
        }
    }

}