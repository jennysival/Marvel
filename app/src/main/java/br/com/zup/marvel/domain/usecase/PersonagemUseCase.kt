package br.com.zup.marvel.domain.usecase

import android.app.Application
import br.com.zup.marvel.data.datasource.local.PersonagemDataBase
import br.com.zup.marvel.domain.model.PersonagemModel
import br.com.zup.marvel.domain.repository.PersonagemRepository

class PersonagemUseCase(application: Application) {
    private val personagemDAO = PersonagemDataBase.getDatabase(application).personagemDao()
    private val personagemRepository = PersonagemRepository(personagemDAO)

    //TODO: Como eu trato o erro caso tenha alguma exception?
    fun getAllPersonagens(): List<PersonagemModel> {
        return personagemRepository.getAllPersonagens()
    }

    fun insertPersonagem(personagem: PersonagemModel){
        personagemRepository.insertPersonagem(personagem)
    }

}