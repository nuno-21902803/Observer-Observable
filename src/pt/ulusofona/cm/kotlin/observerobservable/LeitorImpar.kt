package pt.ulusofona.cm.kotlin.observerobservable

import pt.ulusofona.cm.kotlin.observerobservable.Interfaces.Leitor
import pt.ulusofona.cm.kotlin.observerobservable.Interfaces.OnNumeroListener

class LeitorImpar(nome: String) : Leitor(nome), OnNumeroListener {
    val numeros: MutableList<Int> = mutableListOf()

    override fun onReceiveNumero(num: Int) {
        if (num % 2 != 0)
            numeros.add(num)

    }

    fun imprimeNumeros(): String = "$nome leu os seguintes numeros impares: $numeros"

}