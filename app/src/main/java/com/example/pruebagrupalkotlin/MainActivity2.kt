package com.example.pruebagrupalkotlin

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

        class MainActivity2 : AppCompatActivity() {
            internal lateinit var texto: EditText
            internal lateinit var imagen: ImageView
            internal lateinit var recyclerView: RecyclerView
            internal lateinit var tasks: MutableList<TaskEntity>
            internal lateinit var adapter: TasksAdapter

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main2)
                tasks = mutableListOf()
                //tasks = mutableListOf(TaskEntity(name="Inicio",isDone = false),TaskEntity(name="Inicio",isDone = false))

                imagen = findViewById(R.id.imagen) as ImageView
                texto = findViewById(R.id.texto) as EditText



                //deleteAllTasks()
                getTasks()
                //etData2.setText(tasks.toString())
                setUpRecyclerView(tasks)

                btnAddTask.setOnClickListener {
                    addTask(TaskEntity(name = etTask.text.toString()))
                }
            }

            fun setUpRecyclerView(tasks: List<TaskEntity>) {
                adapter = TasksAdapter(tasks, { updateTask(it) }, {deleteTask(it)})
                recyclerView = findViewById(R.id.rvTask)
                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
            }

            fun addTask(task:TaskEntity){
                doAsync {
                    val id = MyTaskApp.database.taskDao().addTask(task) // <- Crea el registro (insert)
                    val recoveryTask = MyTaskApp.database.taskDao().getTaskById(id) // <- Se recupera el task con ID

                    uiThread {
                        tasks.add(recoveryTask)
                        adapter.notifyItemInserted(tasks.size)
                        clearFocus()
                        hideKeyboard()
                    }

                }
            }

            fun deleteTask(task: TaskEntity){
                doAsync {
                    val position = tasks.indexOf(task)
                    MyTaskApp.database.taskDao().deleteTask(task) // <-- Borra la task en la BD
                    tasks.remove(task) // <-- Borra la task en la lista
                    uiThread {
                        adapter.notifyItemRemoved(position) // <-- Borra el item en el RecyclerView
                    }
                }
            }

            fun deleteAllTasks() {
                doAsync {
                    MyTaskApp.database.taskDao().deleteAllTasks()
                }
            }

            fun getTasks() {
                doAsync {
                    tasks = MyTaskApp.database.taskDao().getAllTasks()
                    etData.setText(tasks.toString())
                }
                etData2.setText(tasks.toString())
            }

            fun updateTask(task: TaskEntity) {
                doAsync {
                    task.isDone = !task.isDone
                    MyTaskApp.database.taskDao().updateTask(task)
                }
            }

            fun clearFocus(){
                etTask.setText("")
            }

            fun Context.hideKeyboard() {
                val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
        }
    }
}