package br.com.zup.tabuada

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Tabuada(private val valorDaTabuada: Int) : Parcelable {
    fun getValor() = this.valorDaTabuada
}