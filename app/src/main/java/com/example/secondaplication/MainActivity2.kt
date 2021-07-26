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
        var boolIva = false
        val txteditSubTotal = findViewById<EditText>(R.id.inpSubTotal)
        var subTotal = ConvertToInt(txteditSubTotal.toString());
        var valueSubtotal = 0;
        var valueIva = 0;
        var operation = 0;
        var resultComi=0.0;


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

        txteditSubTotal.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                txttotal.setText(s.toString())
                txttotal2.setText(s.toString())
                valueSubtotal = s.toString().toInt()
                if(boolIva)
                {
                    valueIva = GetPorcentage(s.toString().toInt(), 12)
                    operation = s.toString().toInt() + valueIva.toString().toInt()
                    txtiva.setText(valueIva.toString())
                    txttotal.setText(operation.toString())
                }else
                {
                    valueIva = 0;
                    operation = s.toString().toInt() + valueIva.toString().toInt()
                    txttotal.setText(operation.toString())
                }

            }

            override fun afterTextChanged(s: Editable?) {
                valueSubtotal = s.toString().toInt()
                if(boolIva)
                {   valueIva = GetPorcentage(s.toString().toInt(), 12)
                    operation = s.toString().toInt() + valueIva.toString().toInt()
                    txtiva.setText(valueIva.toString())
                    txttotal.setText(operation.toString())
                }else
                {
                    valueIva = 0;
                    operation = s.toString().toInt() + valueIva.toString().toInt()
                    txttotal.setText(operation.toString())
                }
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
                        boolIva = false;
                        txtiva.setText("0")
                        txttotal.setText(valueSubtotal.toString())
                    }
                    1 -> {
                        boolIva = true;
                        txtiva.setText(GetPorcentage(valueSubtotal.toString().toInt(), 12).toString())
                        txttotal.setText((valueSubtotal.toString().toInt() + GetPorcentage(valueSubtotal.toString().toInt(), 12)).toString() )
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        })
        commision.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position){
                    0 -> {
                        var itemOne = GetPorcentageDec(valueSubtotal.toString().toInt(),4.5.toDouble())
                        resultComi = valueSubtotal-itemOne
                        txttotal2.setText(resultComi.toString())
                    }
                    1 -> {
                        var itemTwo = GetPorcentageDec(valueSubtotal.toString().toInt(),2.25.toDouble())
                        resultComi= valueSubtotal-itemTwo
                        txttotal2.setText(resultComi.toString())
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        })

        feedbacktypeCont.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position){
                    0 -> {
                        imprent.setText("0%")
                        impiva.setText("0%")
                    }
                    1 -> {
                        imprent.setText("2%")
                        impiva.setText("0%")
                        var x = GetPorcentage(valueSubtotal,2)
                        var y = resultComi-x
                        txttotal2.setText(y.toString())
                    }
                    2 -> {
                        imprent.setText("2%")
                        impiva.setText("10%")
                        var x = GetPorcentage(valueSubtotal,2)
                        var y = resultComi-x
                        txttotal2.setText(y.toString())
                    }
                    3 -> {
                        imprent.setText("2%")
                        impiva.setText("20%")
                        var x = GetPorcentage(valueSubtotal,2)
                        var y = resultComi-x
                        txttotal2.setText(y.toString())
                    }
                    4 -> {
                        imprent.setText("2%")
                        impiva.setText("30%")
                        var x = GetPorcentage(valueSubtotal,2)
                        var y = resultComi-x
                        txttotal2.setText(y.toString())
                    }
                    5 -> {
                        imprent.setText("2%")
                        impiva.setText("70%")
                        var x = GetPorcentage(valueSubtotal,2)
                        var y = resultComi-x
                        txttotal2.setText(y.toString())
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        })

    }

    fun ConvertToInt(texto:String):Int
    {
        try {
            return Integer.parseInt(texto)
        } catch (e: Exception) {
            return 0;
        }
    }

    fun GetPorcentage(firstNumber: Int, secondNumber:Int):Int
    {
        try {
            return (firstNumber * secondNumber / 100)
        } catch (e: Exception) {
            return 0;
        }
    }
    fun GetPorcentageDec(firstNumber: Int, secondNumber:Double):Double
    {
        try {
            return (firstNumber * secondNumber / 100)
        } catch (e: Exception) {
            return 0.0;
        }
    }
}