package com.example.expressarc.roomModel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.expressarc.model.CalcDao
import com.example.expressarc.model.DateConverter

@Database(entities = [Calc::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDataBase: RoomDatabase() {

    abstract fun calcDao(): CalcDao

    companion object {

        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            return if (INSTANCE == null) {
                synchronized(this) {
                    Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        "fitness_tracker"
                    )
                    .build()
                }
                INSTANCE as AppDataBase
            } else {
                INSTANCE as AppDataBase
            }
        }
    }

}