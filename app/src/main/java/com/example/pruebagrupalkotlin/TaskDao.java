package com.example.pruebagrupalkotlin;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

public interface TaskDao {
    @Dao
    interface TaskDao {
        @Query("SELECT * FROM task_entity")
        fun getAllTasks(): MutableList<TaskEntity>

        @Insert
        fun addTask(taskEntity : TaskEntity):Long

        @Query("SELECT * FROM task_entity where id like :id")
        fun getTaskById(id: Long): TaskEntity

        @Delete
        fun deleteTask(taskEntity: TaskEntity):Int

        @Update
        fun updateTask(taskEntity: TaskEntity):Int

        @Query("DELETE FROM task_entity")
        fun deleteAllTasks()

    }


}

