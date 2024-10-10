package com.esdraz.appalcoolougasolina

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var precoAlcool: TextInputEditText
    private lateinit var precoGasolina: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        precoAlcool = findViewById(R.id.preco_alcool)
        precoGasolina = findViewById(R.id.preco_gasolina)
        btnCalcular = findViewById(R.id.btn_calcular)


        btnCalcular.setOnClickListener {

            val valorAlcool = precoAlcool.text.toString().toDoubleOrNull() ?: 0.0
            val valorGasolina = precoGasolina.text.toString().toDoubleOrNull() ?: 0.0

            val resultado = valorAlcool / valorGasolina

            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("alcool", valorAlcool)
            intent.putExtra("gasolina", valorGasolina)

            if (resultado > 0.7) {
                intent.putExtra("resultado", "Gasolina")
            } else {
                intent.putExtra("resultado", "Álcool")
            }

            startActivity(intent)

        }
    }
}