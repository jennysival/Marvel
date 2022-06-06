package br.com.zup.marvel.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

class Personagem(private var nome: String, private var descricao: String) : Parcelable{

    fun getNome() = nome
    fun getDescricao() = descricao
}