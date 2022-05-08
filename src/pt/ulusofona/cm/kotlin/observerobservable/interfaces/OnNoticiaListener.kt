package pt.ulusofona.cm.kotlin.observerobservable.interfaces

import pt.ulusofona.cm.kotlin.observerobservable.models.Noticia

interface OnNoticiaListener : Registavel {

    fun onReceiveNoticia(noticia: Noticia)
}