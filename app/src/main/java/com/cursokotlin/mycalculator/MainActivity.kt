package com.cursokotlin.mycalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cursokotlin.mycalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var vBind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        vBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vBind.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        vBind.calcular.setOnClickListener { calcular() }

    }//llave de cierre método on create

    fun calcular(){

        val num1 = vBind.input1.text.toString().toInt()
        val num2 = vBind.input2.text.toString().toInt()

        if(vBind.sumar.isChecked == true){
            val resultado = num1 + num2
            vBind.respuesta.setText(resultado.toString())
        }
        if(vBind.restar.isChecked == true){
            val resultado = num1 - num2
            vBind.respuesta.setText(resultado.toString())
        }
        if (vBind.mult.isChecked == true){
            val resultado = num1 * num2
            vBind.respuesta.setText(resultado.toString())
        }
        if (vBind.div.isChecked == true){
            val resultado = num1 / num2
            vBind.respuesta.setText(resultado.toString())
        }

    }

}