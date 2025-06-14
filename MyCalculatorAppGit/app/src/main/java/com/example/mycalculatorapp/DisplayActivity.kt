package com.example.mycalculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val result:String= intent.
        getDoubleExtra("output",0.00).toString()

        val tv:TextView=findViewById(R.id.tvResult)
        tv.text=result
//setText is called on txtAnswer, a TextView object.
        val btnBack:Button=findViewById(R.id.btnBack)
        btnBack.setOnClickListener{

            var intent=Intent(this,
                MainActivity::class.java)

            startActivity(intent)
        }

    }
}