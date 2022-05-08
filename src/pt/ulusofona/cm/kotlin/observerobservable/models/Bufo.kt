package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class Bufo(nome : String) : Leitor(nome), OnNumeroListener, OnNoticiaListener {
    val numeros: MutableList<Int> = mutableListOf()
    val noticias: MutableList<Noticia> = mutableListOf()

    override fun onReceiveNoticia(noticia: Noticia) {
        noticias.add(noticia)
    }

    override fun onReceiveNumero(num: Int) {
        numeros.add(num)
    }

    fun imprimeNumeros(): String = "$nome leu os seguintes numeros: $numeros"

    fun imprimeNoticias(): String = "$nome leu as seguintes noticias: $noticias"

}