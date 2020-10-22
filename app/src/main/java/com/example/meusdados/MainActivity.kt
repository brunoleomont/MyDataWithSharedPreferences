package com.example.meusdados

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arqSetting: String = "info"
        val sharedProfile = "kotlinsharedpreferences"

        val inputName = findViewById<EditText>(R.id.editTextTextPersonName)
        val inputRg = findViewById<EditText>(R.id.editTextTextPersonName2)
        val inputCpf = findViewById<EditText>(R.id.editTextTextPersonName3)

        val outputName = findViewById<TextView>(R.id.textView5)
        val outputRg = findViewById<TextView>(R.id.textView6)
        val outputCpf = findViewById<TextView>(R.id.textView7)

        val btnSalvar = findViewById<Button>(R.id.button2)
        val btnLimpar = findViewById<Button>(R.id.button3)
        val btnMostrar = findViewById<Button>(R.id.button4)

        fun cleanTextView(name: TextView, rg: TextView, cpf: TextView) {
            name.setText("").toString()
            rg.setText("").toString()
            cpf.setText("").toString()
        }

        cleanTextView(outputName, outputRg, outputCpf)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedProfile, Context.MODE_PRIVATE)

        btnSalvar.setOnClickListener {
            val name: String = inputName.text.toString()
            val rg: String = inputRg.text.toString()
            val cpf: String = inputCpf.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            editor.putString("name", name)
            editor.putString("rg", rg)
            editor.putString("cpf", cpf)

            editor.apply()
            editor.commit()
        }

        btnLimpar.setOnClickListener {
            val editor = sharedPreferences.edit()

            editor.clear()

            cleanTextView(inputName, inputRg, inputCpf)

            cleanTextView(outputName, outputRg, outputCpf)
        }

        btnMostrar.setOnClickListener {
            val sharedName = sharedPreferences.getString("name", "name")
            val rg = sharedPreferences.getString("rg", "rg")
            val cpf = sharedPreferences.getString("cpf", "cpf")

            outputName.setText(sharedName).toString()
            outputRg.setText(rg).toString()
            outputCpf.setText(cpf).toString()
        }
    }
}