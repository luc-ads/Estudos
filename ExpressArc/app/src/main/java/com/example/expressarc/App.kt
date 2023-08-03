package com.example.expressarc

import android.app.Application
import com.example.expressarc.roomModel.AppDataBase

class App: Application() {

    lateinit var db: AppDataBase

    override fun onCreate() {
        super.onCreate()

        db = AppDataBase.getDataBase(this)
    }
}