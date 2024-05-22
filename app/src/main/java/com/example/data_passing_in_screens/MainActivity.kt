package com.example.data_passing_in_screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY="com.example.DATA_PASSING_IN_SCREENS.MainActivity.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnOrder=findViewById<Button>(R.id.button)
        btnOrder.setOnClickListener{
            val et1=findViewById<EditText>(R.id.et1)
            val et2=findViewById<EditText>(R.id.et2)
            val et3=findViewById<EditText>(R.id.et3)
            val et4=findViewById<EditText>(R.id.et4)
             val orders_list=et1.text.toString()  +" "+et2.text.toString()  +" "+et3.text.toString()  +" "+
                     et4.text.toString()
            intent= Intent(this,order_show::class.java)
            intent.putExtra(KEY,orders_list)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}