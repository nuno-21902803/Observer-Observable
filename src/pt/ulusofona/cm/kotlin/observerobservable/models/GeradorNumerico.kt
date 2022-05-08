package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class GeradorNumerico(val maxLeitores: Int, private val numeros: List<Int>) {
    private val leitores: MutableList<OnNumeroListener> = mutableListOf()

    fun adicionarLeitor(leitor: OnNumeroListener) {
        if (leitores.size + 1 < maxLeitores) {
            leitores.add(leitor)
            leitor.leitorAdicionadoComSucesso()

        } else {
            throw LimiteDeLeitoresAtingidoException("GeradorNumerico atingiu o número máximo de leitores: ${maxLeitores}.")
        }
    }


    fun removerLeitor(leitor: OnNumeroListener) {
        for (l in leitores) {
            if (l == leitor) {
                leitores.remove(leitor)
                leitor.leitorRemovidoComSucesso()
            } else {
                throw LeitorInexistenteException("Este leitor não está registado!")
            }
        }
    }

    private fun notificarLeitor() {
        for (l in leitores) {
            for (n in numeros) {
                l.onReceiveNumero(n)
            }
        }
    }

    fun iniciar() {
        notificarLeitor()
    }
}