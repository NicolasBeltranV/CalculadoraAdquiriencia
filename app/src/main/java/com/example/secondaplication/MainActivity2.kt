package com.example.secondaplication

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txteditSubTotal = findViewById<EditText>(R.id.inpSubTotal)
        val subtotal = txteditSubTotal.text.toString()

        val feedbacktype = findViewById<Spinner>(R.id.spinnerId)
        val spinnerOptions = feedbacktype.getSelectedItem().toString()

        val txtiva = findViewById<EditText>(R.id.inpIva2)
        txtiva.setInputType(InputType.TYPE_NULL);

        val txttotal = findViewById<EditText>(R.id.inpTotal)
        txttotal.setInputType(InputType.TYPE_NULL);

        val commision = findViewById<Spinner>(R.id.spinCard)
        val commisionOpt = commision.getSelectedItem().toString()

        val feedbacktypeCont = findViewById<Spinner>(R.id.spinContr)
        val spinnerOptionsCont = feedbacktypeCont.getSelectedItem().toString()

        val imprent = findViewById<EditText>(R.id.inpImpRent)
        imprent.setInputType(InputType.TYPE_NULL);


        val impiva = findViewById<EditText>(R.id.inpIva)
        impiva.setInputType(InputType.TYPE_NULL);

        val txttotal2 = findViewById<EditText>(R.id.inpTotalTwo)
        txttotal2.setInputType(InputType.TYPE_NULL);

        val subTotal = txteditSubTotal.text.toInt()*0.12
        //val resultado =




        txteditSubTotal.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                txttotal.setText(s.toString())
                txttotal2.setText(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        feedbacktype.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position){
                    0 -> {
                        txtiva.setText("$subTotal")
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })
    }
}

