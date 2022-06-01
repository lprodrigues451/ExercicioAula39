package br.com.zup.caixadesupermercado.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import br.com.zup.caixadesupermercado.PRODUTO
import br.com.zup.caixadesupermercado.R
import br.com.zup.caixadesupermercado.databinding.ActivityMainBinding
import br.com.zup.caixadesupermercado.informacao.DetalheDaCompra
import br.com.zup.caixadesupermercado.model.Produto

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
        val nomeProduto = binding.etNomeProduto.text.toString()
        val qtdProduto = binding.etQtdProduto.text.toString()
        val valorProduto = binding.etValorProduto.text.toString()

        if (nomeProduto.isNotEmpty()
            && qtdProduto.isNotEmpty()
            && valorProduto.isNotEmpty()
        ) {

            val produtoDigitado = Produto(nomeProduto, qtdProduto.toDouble(), valorProduto.toDouble())

            val intentUm = Intent(this, DetalheDaCompra::class.java).apply {
                putExtra(PRODUTO,produtoDigitado)
            }
            startActivity(intentUm)
        } else {
            binding.etNomeProduto.error = "Campo obrigatorio!"
            binding.etQtdProduto.error = "Campo obrigatorio!"
            binding.etValorProduto.error = "Campo obrigatorio!"

        }
    }
}
