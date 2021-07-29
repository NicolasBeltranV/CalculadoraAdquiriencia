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
import java.text.DecimalFormat

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var boolIva = false
        val txteditSubTotal = findViewById<EditText>(R.id.inpSubTotal)
        var subTotal = ConvertToInt(txteditSubTotal.toString())
        var valueSubtotal = 0
        var valueIva = 0
        var operation = 0
        var commisionTarjeta=0.0
        var resultCommision = 0.0
        val feedbacktype = findViewById<Spinner>(R.id.spinnerId)
        val txtiva = findViewById<EditText>(R.id.inpIva2)
        txtiva.setInputType(InputType.TYPE_NULL)
        val txttotal = findViewById<EditText>(R.id.inpTotal)
        var total = 0.0
        txttotal.setInputType(InputType.TYPE_NULL)
        val commision = findViewById<Spinner>(R.id.spinCard)
        val feedbacktypeCont = findViewById<Spinner>(R.id.spinContr)
        val imprent = findViewById<EditText>(R.id.inpImpRent)
        imprent.setInputType(InputType.TYPE_NULL)
        val impiva = findViewById<EditText>(R.id.inpIva)
        impiva.setInputType(InputType.TYPE_NULL)
        val txttotal2 = findViewById<EditText>(R.id.inpTotalTwo)
        txttotal2.setInputType(InputType.TYPE_NULL)

        txteditSubTotal.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                txttotal.setText(s.toString())




                if(s.toString().trim().isEmpty())
                {
                    commision.setSelection(0)
                    feedbacktypeCont.setSelection(0)
                    feedbacktype.setSelection(0)

                    valueSubtotal = 0
                }else{
                    valueSubtotal = s.toString().toInt()
                }

                if(boolIva)
                {
                    valueIva = GetPorcentage(valueSubtotal, 12)
                    operation = valueSubtotal + valueIva.toString().toInt()
                    txtiva.setText(valueIva.toString())
                    txttotal.setText(operation.toString())
                    txttotal2.setText(operation.toString())

                }else
                {
                    valueIva = 0
                    operation = valueSubtotal - valueIva.toString().toInt()
                    txttotal.setText(operation.toString())
                    txttotal2.setText(txttotal.text.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {

                if(s.toString().trim().isEmpty())
                {
                    valueSubtotal = 0
                }else{
                    valueSubtotal = s.toString().toInt()
                }

                if(boolIva)
                {
                    valueIva = GetPorcentage(valueSubtotal, 12)
                    operation = valueSubtotal + valueIva.toString().toInt()
                    txtiva.setText(valueIva.toString())
                    txttotal.setText(operation.toString())
                    txttotal2.setText(operation.toString())
                }else
                {
                    valueIva = 0
                    operation = valueSubtotal - valueIva.toString().toInt()
                    txttotal.setText(operation.toString())
                    txttotal2.setText(txttotal.text.toString())
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
                        boolIva = false
                    }
                    1 -> {
                        boolIva = false
                        txtiva.setText("0")
                        txttotal.setText(valueSubtotal.toString())
                        txttotal2.setText(total.toString())
                        total = txttotal.text.toString().toDouble();
                    }
                    2 -> {
                        boolIva = true
                        txtiva.setText(GetPorcentage(valueSubtotal.toString().toInt(), 12).toString())
                        txttotal.setText((valueSubtotal.toString().toInt() + GetPorcentage(valueSubtotal.toString().toInt(), 12)).toString() )
                        txttotal2.setText((valueSubtotal.toString().toInt() + GetPorcentage(valueSubtotal.toString().toInt(), 12)).toString() )
                        total = txttotal.text.toString().toDouble();
                        //println(total)
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
                        resultCommision = 0.0
                        commisionTarjeta = total - 0.0
                        txttotal2.setText(total.toString())
                    }
                    1 -> {
                        resultCommision = GetPorcentageDeci(txttotal.text.toString().toDouble(), 4.5)
                        commisionTarjeta = resta(txttotal.text.toString().toDouble(),resultCommision)
                        txttotal2.setText(commisionTarjeta.toString())
                        println(resultCommision)
                    }
                    2 -> {
                        resultCommision = GetPorcentageDeci(txttotal.text.toString().toDouble(),2.24)
                        commisionTarjeta= resta(txttotal.text.toString().toDouble(),resultCommision)
                        txttotal2.setText(commisionTarjeta.toString())
                        println(resultCommision)
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
                        imprent.setText("")
                        impiva.setText("")
                        txttotal2.setText("0")
                    }
                    1 -> {
                        imprent.setText("0%")
                        impiva.setText("0%")
                        val df = DecimalFormat("#.##")
                        val op = total-resultCommision
                        txttotal2.setText(df.format(op))
                        println(op)
                    }
                    2 -> {
                        imprent.setText("2%")
                        impiva.setText("0%")
                        var retentionSubtotal = GetPorcentage(valueSubtotal.toString().toInt() ,2)
                        var sumRetentions = resultCommision + retentionSubtotal
                        var totalComm = total - sumRetentions
                        val df = DecimalFormat("#.##")
                        txttotal2.setText(df.format(totalComm))
                    }
                    3 -> {
                        imprent.setText("2%")
                        impiva.setText("10%")
                        var retentionSubtotal = GetPorcentage(valueSubtotal,2)
                        var resultIva = GetPorcentageDec(txtiva.text.toString().toDouble(),10)
                        var sumRetentions = resultCommision+retentionSubtotal+resultIva
                        var totalComm = total - sumRetentions
                        val df = DecimalFormat("#.##")
                        txttotal2.setText(df.format(totalComm))

                    }
                    4 -> {
                        imprent.setText("2%")
                        impiva.setText("20%")
                        var retentionSubtotal = GetPorcentage(valueSubtotal,2)
                        var porcentageIva = GetPorcentageDec(txtiva.text.toString().toDouble(),20)
                        var sumRetentions = resultCommision+retentionSubtotal+porcentageIva
                        var totalComm = total - sumRetentions
                        val df = DecimalFormat("#.##")
                        txttotal2.setText(df.format(totalComm))
                    }
                    5 -> {
                        imprent.setText("2%")
                        impiva.setText("30%")
                        var retentionSubtotal = GetPorcentage(valueSubtotal,2)
                        var porcentageIva = GetPorcentageDec(txtiva.text.toString().toDouble(),30)
                        var sumRetentions = resultCommision+retentionSubtotal+porcentageIva
                        var totalComm = total - sumRetentions
                        val df = DecimalFormat("#.##")
                        txttotal2.setText(df.format(totalComm))
                    }
                    6 -> {
                        imprent.setText("2%")
                        impiva.setText("70%")
                        var retentionSubtotal = GetPorcentage(valueSubtotal,2)
                        var porcentageIva = GetPorcentageDec(txtiva.text.toString().toDouble(),70)
                        var sumRetentions = resultCommision+retentionSubtotal+porcentageIva
                        var totalComm = total - sumRetentions
                        val df = DecimalFormat("#.##")
                        txttotal2.setText(df.format(totalComm))
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
            return 0
        }
    }
    fun CreditValidationC(subtotal:Int, p: Double):Double
    {
        try {
            return subtotal * p / 100
        } catch (e: Exception) {
            return 0.0
        }
    }

    fun GetPorcentage(firstNumber: Int, secondNumber:Int):Int
    {
        try {
            return (firstNumber * secondNumber / 100)
        } catch (e: Exception) {
            return 0
        }
    }
    fun GetPorcentageDec(firstNumber: Double, secondNumber:Int):Double
    {
        try {
            return (firstNumber * secondNumber / 100)
        } catch (e: Exception) {
            return 0.0
        }
    }
    fun GetPorcentageDeci(firstNumber: Double, secondNumber:Double):Double
    {
        try {
            return (firstNumber * secondNumber / 100)
        } catch (e: Exception) {
            return 0.0
        }
    }
    fun resta(firstNumber: Double,secondNumber: Double):Double {
        try {
            return (firstNumber - secondNumber)
        } catch (e: Exception) {
            return 0.0
        }
    }
}