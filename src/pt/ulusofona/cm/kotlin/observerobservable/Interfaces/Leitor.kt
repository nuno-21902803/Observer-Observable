package pt.ulusofona.cm.kotlin.observerobservable.Interfaces

abstract class Leitor(val nome : String) : Registavel{
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