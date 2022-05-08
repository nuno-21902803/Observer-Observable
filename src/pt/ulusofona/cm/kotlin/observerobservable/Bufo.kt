package pt.ulusofona.cm.kotlin.observerobservable

import pt.ulusofona.cm.kotlin.observerobservable.Interfaces.Leitor
import pt.ulusofona.cm.kotlin.observerobservable.Interfaces.OnNoticiaListener
import pt.ulusofona.cm.kotlin.observerobservable.Interfaces.OnNumeroListener

class Bufo(nome : String) : Leitor(nome), OnNumeroListener, OnNoticiaListener {
    private val numeros: MutableList<Int> = mutableListOf()
    private val noticias: MutableList<Noticia> = mutableListOf()

    override fun onReceiveNoticia(noticia: Noticia) {
        noticias.add(noticia)
    }

    override fun onReceiveNumero(num: Int) {
        numeros.add(num)
    }

    fun imprimeNumeros(): String = "$nome leu os seguintes numeros: $numeros"

    fun imprimeNoticias(): String = "$nome leu as seguintes noticias: $noticias"

}