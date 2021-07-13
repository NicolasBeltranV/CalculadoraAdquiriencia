package com.example.secondaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario)
        enumClass()
    }
    enum class Direction(){
        NORTH, SOUTH, ESTH, WESTH;

        fun description():String{

            return when (this){
                NORTH->{
                    "La direccion es Norte"
                }
                SOUTH->{
                    "La direccion es Sur"
                }
                ESTH->{
                    "La direccion es Este"
                }
                WESTH->{
                    "La direccion es Oeste"
                }
            }
        }
    }

    fun enumClass(){

        var userDirection: Direction? = null
        println("La direccion es: ${userDirection}")

        userDirection = Direction.ESTH
        println("La direccion es $userDirection")

        println(userDirection.description())
    }
}