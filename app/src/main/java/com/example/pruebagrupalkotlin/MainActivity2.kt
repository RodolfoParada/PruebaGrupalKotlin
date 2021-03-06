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

            lateinit var Vista: RecyclerView
            val adapta: RecyclerAdapter = RecyclerAdapter()
            internal lateinit var texto: EditText
            internal lateinit var imagen: ImageView
            internal lateinit var recyclerView: RecyclerView
            internal lateinit var tasks: MutableList<TaskEntity>
            internal lateinit var adapters: TaskAdapter

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main2)
                //    tasks = mutableListOf()
                //tasks = mutableListOf(TaskEntity(name="Inicio",isDone = false),TaskEntity(name="Inicio",isDone = false))

            }

            fun getTiposTe1(): MutableList<VariedadesTe> {
                var tiposdiferenteste: MutableList<VariedadesTe> = ArrayList()
                tiposdiferenteste.add(VariedadesTe("Té Verde",
                    "https://i.pinimg.com/564x/53/8e/86/538e86392562f6fadc122903485bbe5c.jpg",
                    "El té verde favorece el estado de alerta y agudiza tus habilidades intelectuales. Esto es debido a las propiedades de la cafeína, que en el té va acompañada de l-teanina y no produce el molesto nerviosismo de un café expreso y no solo mejora el funcionamiento del cerebro, sino que previene su degeneración y el desarrollo de enfermedades neurológicas como Parkinson y Alzhéimer."))
                tiposdiferenteste.add(VariedadesTe("Té Negro",
                    "https://i.pinimg.com/564x/27/5f/f6/275ff67e5022b565f8b992ca1a7d7eb1.jpg",
                    "Te Negro Una de las propiedades más destacadas del té negro es que contribuye a disminuir el nivel de colesterol en sangre, con lo cual lo podemos encontrar como ingrediente de numerosos complementos en la farmacia además es estimulante, antioxidante, microbioma intestinal, ayuda a disminuir el sobrepeso."))
                tiposdiferenteste.add(VariedadesTe("Té Verde con Limón",
                    "https://i.pinimg.com/564x/ee/73/92/ee7392d93bacad1a200ddd4a85568687.jpg",
                    "Te verde con limón ayuda a hidratar el cuerpo: mientras te aporta vitaminas y minerales, principalmente Vitamina C. Mejora el aspecto de tu piel: ya que éste aporta una gran cantidad de antioxidantes, que regeneran las células de la piel además ayuda a mantener los niveles de alcalinidad: lo que contribuye a que te resulte más sencillo quemar grasas. Y esto sin olvidar que es un potente diurético natural, por lo que también es ideal para reducir la retención de líquidos."))
                tiposdiferenteste.add(VariedadesTe("Té de Jengibre",
                    "https://i.pinimg.com/564x/1e/e5/1c/1ee51ca619dd8c17efebd8f37ca9332e.jpg",
                    "Te de jengibre Si nos centramos únicamente en los beneficios que ofrece el jengibre a la salud destaca su facultad de aliviar las náuseas (es uno de sus beneficios más conocidos) y, según los estudios que se van realizando, también destacaría sus efectos analgésicos como los gingeroles y los fenoles. Algunos afirman que, simplemente, la ciencia ha confirmado ahora lo que hace siglos ya se sabía, que la raíz del jengibre reduce el dolor."))
                tiposdiferenteste.add(VariedadesTe("Té con Miel",
                    "https://i.pinimg.com/564x/bd/35/5a/bd355aa46d0cec2c2d492afc3f8b800f.jpg",
                    "Te con miel esta mezcla es considerada como un remedio para las enfermedades respiratorias, como dolor de garganta, tos o congestión nasal. Sin embargo, también te puede ayudar a eliminar los senos paranasales, aliviar la inflamación en las vías respiratorias y eliminar la tos."))
                tiposdiferenteste.add(VariedadesTe("Té con Canela",
                    "https://i.pinimg.com/564x/0b/bd/e0/0bbde007b2abef5b3544091869a0d95c.jpg",
                    "Te con canela es carminativo, por lo que evita la formación de gases, ayuda a reducir las náuseas y el mareo, estimula la salivación y la secreción de jugos gástricos, al mismo tiempo que protege el estómago, mejora la salud del aparato digestivo, ayuda a tratar enfermedades respiratorias, ayuda a expulsar flemas, alivia la congestión y reduce la fiebre, estimula la circulación sanguínea, mejora las funciones cerebrales, fomenta la memoria y previene el Alzheimer, disminuye los dolores y molestias de la menstruación, ayuda a reducir los niveles de colesterol, equilibra los niveles de glucosa en la sangre, sus antioxidantes ayudan a combatir el envejecimiento celular y mejoran la salud de la piel, ayuda a tratar y prevenir la aparición de varices, es bueno para las dietas de control de peso, ya que ayuda a que el cuerpo procese mejor los carbohidratos y grasas."))
                tiposdiferenteste.add(VariedadesTe("Té con Manzanilla",
                    "https://i.pinimg.com/564x/97/28/1a/97281a7f8cb1954d493ea216f8796413.jpg",
                    "El té de manzanilla por siglos, esta hierba ha tenido una larga historia de uso tradicional por sus efectos calmantes. Las tradiciones Ayurveda seculares han reconocido a la manzanilla por sus efectos calmantes y tranquilizantes. Ha sido usado como remedio tradicional para la relajación. También se ha utilizado para el insomnio describiéndose algunos usos antes de ir a dormir."))
                tiposdiferenteste.add(VariedadesTe("Té de Menta",
                    "https://i.pinimg.com/564x/d6/99/4f/d6994f857ffc25d52887ac25f5069a16.jpg",
                    "El te de menta es conocida por sus propiedades antibacterianas, ¡evitando que te enfermes! También contiene vitamina B, potasio, calcio y antioxidantes, que pueden ayudar a la absorción de los nutrientes del cuerpo para combatir las enfermedades además es sedante natural y la naturaleza antiespasmódica del mentol hace que sea muy bueno para aliviar el estrés mental, reduciendo la presión arterial y la temperatura corporal."))
                return tiposdiferenteste
            }

            fun setUpRecyclerViewx() {
                recyclerView = findViewById(R.id.dess) as RecyclerView
                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager = LinearLayoutManager(this)
                adapters.TaskAdapter(getTiposTe1(), this)
                recyclerView.adapter = adapters
            }
        }




/*

                imagen = findViewById(R.id.imagenes) as ImageView
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
                recyclerView = findViewById(R.id.
                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
            }

            fun addTask(task:TaskEntity){
                doAsync {
                    val id = TaskApp.database.taskDao().addTask(task) // <- Crea el registro (insert)
                    val recoveryTask = TaskApp.database.taskDao().getTaskById(id) // <- Se recupera el task con ID

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
*/
