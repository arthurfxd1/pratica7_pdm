package com.example.pratica7_pdm

import android.os.Bundle as bundle
import androidx.appcompat.app.AppCompatActivity as activity
import android.widget.Button as button
import android.widget.EditText as edittext
import android.content.Intent as intencao
import com.example.pratica7_pdm.R as r

class mainactivity : activity() {
    override fun onCreate(b: bundle?) {
        super.onCreate(b)
        setContentView(r.layout.activity_main)

        val campo = findViewById<edittext>(r.id.edit_destino)
        val botao = findViewById<button>(r.id.button_planejar)

        botao.setOnClickListener {
            val destino = campo.text.toString()
            if (destino.isNotEmpty()) {
                val i = intencao(this, destinoactivity::class.java)
                i.putExtra("destino", destino)
                startActivity(i)
            }
        }
    }
}
