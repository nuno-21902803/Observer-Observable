package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LeitorInexistenteException
import pt.ulusofona.cm.kotlin.observerobservable.exceptions.LimiteDeLeitoresAtingidoException
import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNoticiaListener

class CorreioDaLusofona(val maxLeitores: Int, private val noticias: List<Noticia>) {
    private val leitores: MutableList<OnNoticiaListener> = mutableListOf()

    fun adicionarLeitor(leitor: OnNoticiaListener) {
        if (leitores.size + 1 < maxLeitores) {
            leitores.add(leitor)
            leitor.leitorAdicionadoComSucesso()

        } else {
            throw LimiteDeLeitoresAtingidoException("CorreioDaLusofona atingiu o número máximo de leitores: ${maxLeitores}.")
        }
    }


    fun removerLeitor(leitor: OnNoticiaListener) {
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
            for (n in noticias){
                l.onReceiveNoticia(n)
            }
        }
    }

    fun iniciar() {
        notificarLeitor()
    }


}