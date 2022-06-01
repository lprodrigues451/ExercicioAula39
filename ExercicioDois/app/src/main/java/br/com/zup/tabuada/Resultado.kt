package br.com.zup.tabuada

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.tabuada.databinding.ActivityResultadoBinding

class Resultado : AppCompatActivity() {
    private lateinit var binding : ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Resultado")
        recuperarDados()

        binding.butaoRecalcularTabuada.setOnClickListener {
            val intentUm = Intent(this, MainActivity::class.java)
            startActivity(intentUm)
        }
    }


    private fun recuperarDados(){
        val tabuada = intent.getParcelableExtra<Tabuada>(TABUADA)
        var mostrar = ""
        var i = 1
        while (i <= 10){
            mostrar = mostrar + tabuada?.getValor() + "X" + i + "=" + (tabuada?.getValor()?.times(i)) + "\n"
            i++
        }
        binding.titulo.text = "Tabuada do ${tabuada?.getValor()}"
        binding.descricao.text = mostrar
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}