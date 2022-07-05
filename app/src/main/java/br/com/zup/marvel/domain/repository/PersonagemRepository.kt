package br.com.zup.marvel.domain.repository

import br.com.zup.marvel.data.datasource.local.dao.PersonagemDAO
import br.com.zup.marvel.domain.model.PersonagemModel

class PersonagemRepository(private val personagemDAO: PersonagemDAO) {

    //TODO: O que é esse suspend?
    //TODO: Esse repository está sendo usado corretamente? Inserindo e consultando os dados do DAO
    suspend fun getAllPersonagens(): List<PersonagemModel> = personagemDAO.getAllPersonagens()

    suspend fun insertPersonagem(personagem: PersonagemModel){
        personagemDAO.insertPersonagem(personagem)
    }

}