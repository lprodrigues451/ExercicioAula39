package br.com.zup.caixadesupermercado.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Produto(
    private var nomeProduto:String,
    private var qtdProduto: Double,
    private var valorProduto:Double) : Parcelable {

    fun getNomeProduto() = this.nomeProduto
    fun getQtdProduto() = this.qtdProduto
    fun getValorProduto() = this.valorProduto
}