package com.example.expressarc.model

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    //para buscar ao banco
    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return if (dateLong != null) Date(dateLong) else null
    }

    //para mandar ao banco
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }


}