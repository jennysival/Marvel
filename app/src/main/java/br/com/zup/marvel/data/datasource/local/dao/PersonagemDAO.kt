package br.com.zup.marvel.data.datasource.local.dao

import androidx.room.Dao
import br.com.zup.marvel.domain.model.PersonagemModel

@Dao
interface PersonagemDAO {
    fun adicionarPersonagem(personagemModel: PersonagemModel)
}