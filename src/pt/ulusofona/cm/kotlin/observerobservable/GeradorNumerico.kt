package pt.ulusofona.cm.kotlin.observerobservable

import pt.ulusofona.cm.kotlin.observerobservable.Exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.Exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.Interfaces.OnNoticiaListener
import pt.ulusofona.cm.kotlin.observerobservable.Interfaces.OnNumeroListener

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

    fun inicar() {
        notificarLeitor()
    }
}