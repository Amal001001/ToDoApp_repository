package com.example.todoapp2

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var items: ArrayList<todo>
    private lateinit var rvitems: RecyclerView
    private lateinit var rvadapter: adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = arrayListOf()

        rvitems = findViewById<RecyclerView>(R.id.rvItems)
        rvadapter = adapter(items)
        rvitems.adapter = rvadapter
        rvitems.layoutManager = LinearLayoutManager(this)

        val fabutton = findViewById<FloatingActionButton>(R.id.fabutton)
        fabutton.setOnClickListener { addtask() }
    }


    private fun addtask(){
        val dialogBuilder = AlertDialog.Builder(this)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val toDo = EditText(this)
        toDo.hint = "Enter a task"
        layout.addView(toDo)

        dialogBuilder.setPositiveButton("ADD", DialogInterface.OnClickListener {
                dialog, id -> items.add(todo(toDo.text.toString()))
        })
            .setNegativeButton("CANCEL", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("New task")
        alert.setView(layout)
        alert.show()
    }
}