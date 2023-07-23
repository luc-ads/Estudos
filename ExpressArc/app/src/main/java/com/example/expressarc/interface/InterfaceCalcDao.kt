package com.example.expressarc.`interface`

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.expressarc.roomModel.Calc

@Dao
interface InterfaceCalcDao {

    @Insert
    fun insert(calc: Calc)

    @Delete
    fun delete()

    @Update
    fun update()

//    @Query
//    fun search()

}