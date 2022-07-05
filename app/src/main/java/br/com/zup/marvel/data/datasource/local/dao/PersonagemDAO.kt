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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPersonagem(personagem: PersonagemModel)

}