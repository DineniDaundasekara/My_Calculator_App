package com.example.mycalculatorapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mycalculatorapp.model.Calculator

class MainActivity : AppCompatActivity() {

    lateinit var etNum01:EditText
    lateinit var etNum2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->


            val button1: Button =findViewById(R.id.button2)
            button1.setOnClickListener{
                val btn1= Intent(this@MainActivity,Welcome::class.java)
                startActivity(btn1)

            }
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         etNum01=findViewById(R.id.etNum01)
         etNum2=findViewById(R.id.etNum2)

    }//end of onCreate

    fun onClickButton(v:View)
    {
        var n1:Double=etNum01.text.toString().toDouble()
        var n2:Double=etNum2.text.toString().toDouble()

        var cal:Calculator=Calculator(n1,n2)


        var result:Double=0.0
        when(v.id)
        {
            R.id.btnPlus->result=cal.add()
            R.id.btnMinus->result=cal.subtraction()
            R.id.btnMulti->result=cal.multiply()
            R.id.btnDiv->result=cal.divide()
            //new btn
           // R.id newBtn->result=cal.newFun()
        }

        //Main components of Android
        //1) Activity :Single screen
        //2) Intent: Communication mechanism

           //1 Explicit Intent

        var intent= Intent(this,
            DisplayActivity::class.java)

        intent.putExtra("output",result)

        startActivity(intent)

        //2 implict intent

    }

}//end of main
