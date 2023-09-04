package com.example.expressarc.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.expressarc.roomModel.Calc

@Dao
interface CalcDao {

    @Insert
    fun insert(calc: Calc)

//    @Delete
//    fun delete()
//
//    @Update
//    fun update()

    @Query("SELECT * FROM Calc WHERE type = :type")
    fun getRegisterByType(type: String): List<Calc>

}