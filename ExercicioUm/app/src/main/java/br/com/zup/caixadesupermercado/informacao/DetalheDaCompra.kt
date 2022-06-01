package br.com.zup.caixadesupermercado.informacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.caixadesupermercado.Main.MainActivity
import br.com.zup.caixadesupermercado.PRODUTO
import br.com.zup.caixadesupermercado.R
import br.com.zup.caixadesupermercado.databinding.ActivityDetalheDaCompraBinding
import br.com.zup.caixadesupermercado.model.Produto

class DetalheDaCompra : AppCompatActivity() {
    private lateinit var binding : ActivityDetalheDaCompraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheDaCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.titulo_detalhe_compra)

        recuperarDados()

        binding.butaoRefazerCompra.setOnClickListener{
            retornaMenuInicial()
        }
    }

    private fun recuperarDados(){
        val produto = intent.getParcelableExtra<Produto>(PRODUTO)
        val valorFinal = produto?.getValorProduto()?.times(produto?.getQtdProduto()!!)

        binding.tvResultado.text = "O VALOR TOTAL É DE: R$ $valorFinal"
    }

    private fun retornaMenuInicial(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}