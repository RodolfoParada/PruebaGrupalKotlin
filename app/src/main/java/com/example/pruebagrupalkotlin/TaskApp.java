package com.example.pruebagrupalkotlin;


class TaskApp::Application() {
        companion object {
        lateinit var database: TasksDatabase
        }
        override fun onCreate() {
        super.onCreate()
        MyTaskApp.database =  Room.databaseBuilder(this, TasksDatabase::class.java, "tasks-db").build()
        }
        }