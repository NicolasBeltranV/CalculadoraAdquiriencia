package com.example.secondaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var txteditSubTotal: EditText = findViewById(R.id.editSubtotal)
        var feedbacktype = findViewById<Spinner>(R.id.spinnerId)
        var feedbacktypeCont = findViewById<Spinner>(R.id.spinContr)
        var txttotal : EditText = findViewById(R.id.inpTotal)
        var txtiva : EditText = findViewById(R.id.inpIva)
        var txttotal2 : EditText = findViewById(R.id.inpTotalTwo)
        var edittotal: String = txttotal.text.toString()
        var edittotal2: String = txttotal2.text.toString()
        var editiva: String = txtiva.text.toString()
        var editSubtotal: String = txteditSubTotal.text.toString()
        var spinnerOptions = feedbacktype.getSelectedItem().toString()
        var spinnerOptionsCont = feedbacktypeCont.getSelectedItem().toString()

      
    }
}