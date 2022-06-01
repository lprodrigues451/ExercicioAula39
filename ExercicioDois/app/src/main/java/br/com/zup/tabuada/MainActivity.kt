package br.com.zup.tabuada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.tabuada.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.butaoCalcular.setOnClickListener {
            enviarDadosProdutos()
        }
    }
    private fun enviarDadosProdutos() {
        val valor = binding.etCampoValor.text.toString()


        if (valor.isNotEmpty()
        ) {

            val tabuada = Tabuada(valor.toInt())

            val intentUm = Intent(this, Resultado::class.java).apply {
                putExtra(TABUADA,tabuada)
            }
            startActivity(intentUm)
        } else {
            binding.etCampoValor.error = "Campo obrigatorio!"


        }
    }
}