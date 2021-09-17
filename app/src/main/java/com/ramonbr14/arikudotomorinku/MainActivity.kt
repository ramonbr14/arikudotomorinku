package com.ramonbr14.arikudotomorinku


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast as WidgetToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val campoTexto: EditText = findViewById(R.id.edNome)
        val textodaView: TextView = findViewById(R.id.textosaida)
        val botao: Button = findViewById(R.id.btTraduzir)
        botao.setOnClickListener {
            val textoQualquer: Editable? = campoTexto.text
            campoTexto.setText("")
            //textodaView.text = textoQualquer
            //mensagem(textoQualquer.toString())
            textodaView.text = traduzNomeJapones(textoQualquer.toString()).toString()
        }
    }

    //Funcao unica para o Toast
    private  fun mensagem(mensagem: String){

        val toast: WidgetToast = android.widget.Toast.makeText(this,mensagem,
            android.widget.Toast.LENGTH_LONG)
        toast.show()
    }
    private fun traduzNomeJapones(textotraduzir:String): String {
        var textoa:String = textotraduzir
        val listaJapones: List<String> = listOf("KA", "TU", "MI", "TE", "KU","LU", "JI", "RI", "KI", "ZU", "ME", "TA", "RIN", "TO", "MO", "NO", "KE", "SHI", "ARI", "CHI", "DO", "RU", "NA", "MEI", "FU", "RA")
        //começar a ontar a string de saida co o nome em japones

        mensagem(listaJapones.size.toString())
        return listaJapones.size.toString()
    }
}


