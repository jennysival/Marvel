package br.com.zup.marvel.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.marvel.domain.model.PersonagemModel

@Dao
interface PersonagemDAO {
    @Query("SELECT * FROM personagens ORDER BY nome_personagem ASC")
    fun getAllPersonagens(): List<PersonagemModel>

    @Query("SELECT * FROM personagens WHERE nome_personagem =:nomePersonagem")
    fun getNomePersonagem(nomePersonagem: String): PersonagemModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPersonagem(personagem: PersonagemModel)
    //TODO: Não sei o que esse onConflict replace faz

}