package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.Registavel

abstract class Leitor(val nome : String) : Registavel {
    private var registado : Boolean = false

    override fun leitorAdicionadoComSucesso() {
        registado = true
    }

    override fun leitorRemovidoComSucesso() {
        registado = false
    }

    fun estaRegistado() : Boolean{
        return registado
    }
}