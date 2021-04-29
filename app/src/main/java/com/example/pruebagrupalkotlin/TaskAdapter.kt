package com.example.pruebagrupalkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(){

    private val tasks: List<TaskEntity>,
    private val checkTask: (TaskEntity) -> Unit,
    private val deleteTask: (TaskEntity) -> Unit) : RecyclerView.Adapter<TaskAdapter.ViewHolder>()


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)


        return ViewHolder(layoutInflater.inflate(R.layout.item_task, parent, false))
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TaskAdapter.ViewHolder, position: Int) {
        val item = tasks[position]
        holder.bind(item, checkTask, deleteTask)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTask = view.findViewById<TextView>(R.id.texto)
        val Imagenes = view.findViewById<CheckBox>(R.id.imagenes)

        fun bind(task: TaskEntity, checkTask: (TaskEntity) -> Unit, deleteTask: (TaskEntity) -> Unit) {
            tvTask.text = task.Texto
            Imagenes.setOnClickListener { checkTask(task) }
            itemView.setOnClickListener { deleteTask(task) }
        }
    }

