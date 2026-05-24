package com.example.pratica7_pdm

import android.os.Bundle as bundle
import androidx.appcompat.app.AppCompatActivity as activity
import android.widget.Button as button
import android.widget.TextView as textview
import android.content.Intent as intencao
import android.net.Uri as uri
import com.example.pratica7_pdm.R as r

class destinoactivity : activity() {
    override fun onCreate(b: bundle?) {
        super.onCreate(b)
        setContentView(r.layout.activity_destino)

        val destino = intent.getStringExtra("destino")
        val exibicao = findViewById<textview>(r.id.text_destino_recebido)
        exibicao.text = destino

        val b_mapa = findViewById<button>(r.id.button_mapa)
        val b_voos = findViewById<button>(r.id.button_voos)
        val b_fotos = findViewById<button>(r.id.button_fotos)
        val b_partilhar = findViewById<button>(r.id.button_partilhar)

        b_mapa.setOnClickListener {
            val i = intencao(intencao.ACTION_VIEW, uri.parse("geo:0,0?q=$destino"))
            startActivity(i)
        }

        b_voos.setOnClickListener {
            val i = intencao(intencao.ACTION_VIEW, uri.parse("https://www.google.com/search?q=voos+para+$destino"))
            startActivity(i)
        }

        b_fotos.setOnClickListener {
            val i = intencao(intencao.ACTION_VIEW, uri.parse("https://www.google.com/search?q=$destino&tbm=isch"))
            startActivity(i)
        }

        b_partilhar.setOnClickListener {
            val i = intencao(intencao.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(intencao.EXTRA_TEXT, "estou planejando uma viagem para $destino")
            startActivity(intencao.createChooser(i, "compartilhar"))
        }
    }
}
