package com.esdraz.appalcoolougasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    lateinit var textAlcool: TextView
    lateinit var textGasolina: TextView
    lateinit var textResultado: TextView
    lateinit var btnFechar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textAlcool = findViewById(R.id.text_alcool)
        textGasolina = findViewById(R.id.text_gasolina)
        textResultado = findViewById(R.id.text_resultado)
        btnFechar = findViewById(R.id.btn_fechar)

        val bundle = intent.extras
        val precoAlcool = bundle?.getDouble("alcool")
        textAlcool.text = "Preço Álcool: $precoAlcool"

        val precoGasolina = bundle?.getDouble("gasolina")
        textGasolina.text = "Preço Gasolina: $precoGasolina"

        val resultado = bundle?.getString("resultado")
        textResultado.text = resultado

        btnFechar.setOnClickListener {
            finish()
        }
    }
}