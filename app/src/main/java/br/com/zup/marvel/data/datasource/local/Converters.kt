package br.com.zup.marvel.data.datasource.local

import androidx.room.TypeConverter
import br.com.zup.marvel.domain.model.PersonagemModel
import com.google.gson.Gson


//TODO: Por que eu preciso dessa classe de converter?
class Converters {
    @TypeConverter
    fun converterToPersonagem(value: String): PersonagemModel?{
        return Gson().fromJson(value, PersonagemModel::class.java)
    }

    @TypeConverter
    fun converterToJson(personagem: PersonagemModel): String{
        return Gson().toJson(personagem)
    }
}