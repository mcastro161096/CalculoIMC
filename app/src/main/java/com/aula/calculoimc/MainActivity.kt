package com.aula.calculoimc

import android.icu.math.BigDecimal
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val peso : EditText
        val altura : EditText
        val calcular : Button
        val resultado : TextView
        var imc : Double
        var imcConvertido : String
        peso = findViewById(R.id.peso)
        altura = findViewById(R.id.altura)
        calcular = findViewById(R.id.calcular)
        resultado = findViewById(R.id.resultado)
        calcular.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                imc = peso.text.toString().toDouble()/(altura.text.toString().toDouble()*altura.text.toString().toDouble())
                imcConvertido = String.format("%.2f", imc)

                when(imc)
                {
                    in 0.0..15.99 -> resultado.text ="Seu IMC é " + imcConvertido + " está fora dos valores\n de parâmetro, verifique se preencheu o \nvalor correto!"
                    in 16.0..16.99 -> resultado.text ="Seu IMC é " + imcConvertido + " Muito abaixo do peso"
                    in 17.0..18.4 ->  resultado.text = "Seu IMC é " + imcConvertido +  " Abaixo do peso"
                    in 18.5..24.99 -> resultado.text =  "Seu IMC é " + imcConvertido +   " Peso normal"
                    in 25.0..29.99 -> resultado.text = "Seu IMC é " + imcConvertido +   " Acima do peso"
                    in 30.0..34.99 ->resultado.text = "Seu IMC é " + imcConvertido +   " Obesidade grau I"
                    in 35.0..40.0 -> resultado.text = "Seu IMC é " + imcConvertido +   " Obesidade grau II"
                    in 40.0..2000.0 -> resultado.text = "Seu IMC é " + imcConvertido +  " Obesidade grau III"
                }

            }
        })
    }
}