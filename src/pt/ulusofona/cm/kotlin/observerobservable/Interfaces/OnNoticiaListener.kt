package pt.ulusofona.cm.kotlin.observerobservable.Interfaces

import pt.ulusofona.cm.kotlin.observerobservable.Noticia

interface OnNoticiaListener : Registavel {

    fun onReceiveNoticia(noticia: Noticia)
}