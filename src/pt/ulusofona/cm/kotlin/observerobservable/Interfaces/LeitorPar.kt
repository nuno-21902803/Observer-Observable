package pt.ulusofona.cm.kotlin.observerobservable.Interfaces

class LeitorPar(nome: String) : Leitor(nome), OnNumeroListener {
    val numeros: MutableList<Int> = mutableListOf()

    override fun onReceiveNumero(num: Int) {
        if (num % 2 == 0)
            numeros.add(num)

    }

    fun imprimeNumeros(): String = "$nome leu os seguintes numeros pares: $numeros"

}