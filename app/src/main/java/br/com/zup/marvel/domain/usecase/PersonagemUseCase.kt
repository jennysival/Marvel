package br.com.zup.marvel.domain.usecase

import android.app.Application
import br.com.zup.marvel.data.datasource.local.PersonagemDataBase
import br.com.zup.marvel.domain.model.PersonagemModel
import br.com.zup.marvel.domain.repository.PersonagemRepository
import br.com.zup.marvel.ui.addpersonagem.view.Personagem

class PersonagemUseCase(application: Application) {
    private val personagemDAO = PersonagemDataBase.getDatabase(application).personagemDao()
    private val personagemRepository = PersonagemRepository(personagemDAO)

    //TODO: Como eu trato o erro caso tenha alguma exception?
    suspend fun getAllPersonagens(): List<PersonagemModel> {
        return personagemRepository.getAllPersonagens()
    }

    suspend fun insertPersonagens(personagem: PersonagemModel){
        personagemRepository.insertPersonagem(personagem)
    }

}