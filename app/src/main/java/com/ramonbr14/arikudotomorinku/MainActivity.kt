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
            textodaView.text = traduzNomeJapones(textoQualquer.toString())
        }
    }

    //Funcao unica para o Toast
    private  fun mensagem(mensagem: String){
            val toast: WidgetToast = android.widget.Toast.makeText(this,mensagem,
            android.widget.Toast.LENGTH_LONG)
            toast.show()
    }
    private fun traduzNomeJapones(textotraduzir:String): String {
        val textoa:String = textotraduzir.uppercase()
        var nomeJapones = ""
        val alfabeto: List<Char> = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
        val listaJapones: List<String> = listOf("KA", "TU", "MI", "TE", "KU","LU", "JI", "RI", "KI", "ZU", "ME", "TA", "RIN", "TO", "MO", "NO", "KE", "SHI", "ARI", "CHI", "DO", "RU", "NA", "MEI", "FU", "RA")

        var i = 0
        do{
            var p = 0
            do{
                if(textoa[i].isLetter()) {
                    if((textoa[i].toString()) == alfabeto[p].toString()) {
                        nomeJapones += listaJapones[p]
                        p = alfabeto.size - 1
                    }else{
                        p++
                    }
                }else{
                    nomeJapones += textoa[i]
                    p = alfabeto.size - 1
                }
            }while(p!=(alfabeto.size-1))
        i++
        }while(i<=(textoa.length-1))
        mensagem("TRADUÇÃO CONCLUIDA")
        return nomeJapones
    }
}

