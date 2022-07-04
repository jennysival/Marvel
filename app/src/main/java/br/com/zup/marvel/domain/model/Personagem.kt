package br.com.zup.marvel.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Personagem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cod_personagem")
    var codPersonagem: Long = 1,

    @ColumnInfo(name = "nome_personagem")
    var nome: String,

    @ColumnInfo(name = "descricao_personagem")
    var descricao: String
    )
    : Parcelable