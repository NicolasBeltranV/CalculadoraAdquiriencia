package com.example.secondaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Spinner
import androidx.core.widget.addTextChangedListener

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var txteditSubTotal = findViewById<EditText>(R.id.inpSubTotal)


        var feedbacktype = findViewById<Spinner>(R.id.spinnerId)
        var spinnerOptions = feedbacktype.getSelectedItem().toString()

        var feedbacktypeCont = findViewById<Spinner>(R.id.spinContr)
        var spinnerOptionsCont = feedbacktypeCont.getSelectedItem().toString()

        var txttotal = findViewById<EditText>(R.id.inpTotal)


        var txtiva = findViewById<EditText>(R.id.inpIva)


        var txttotal2 = findViewById<EditText>(R.id.inpTotalTwo)


        txteditSubTotal.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                txttotal.setText(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
}