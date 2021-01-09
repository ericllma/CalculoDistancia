package com.example.calculodistancia

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botao.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        calcular()
    }

    private fun calcular() {
        if (validationOK()) {
            try {
                val distancia = editDistancia.text.toString().toFloat()
                val preco = editPreco.text.toString().toFloat()
                val autonomia = editAutonomia.text.toString().toFloat()
                val totalFinal = (distancia * preco) / autonomia

                total.text = "R$ ${"%.2f".format(totalFinal)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.alerta_valores_validos), Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.alerta_preencher_campos), Toast.LENGTH_SHORT).show()
        }

    }

    private fun validationOK(): Boolean {
        return (editDistancia.text.toString() != "" && editAutonomia.text.toString() != ""
                && editPreco.text.toString() != "" && editAutonomia.text.toString() != "0")

    }


}

