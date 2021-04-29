package com.example.pruebagrupalkotlin

import android.app.Application
import androidx.room.Room

class TaskApp: Application() {
    companion object {
        lateinit var database: TasksDatabase
    }

    override fun onCreate() {
        super.onCreate()
        TaskApp.database =  Room.databaseBuilder(this, TasksDatabase::class.java, "tasks-db").build()
    }
}