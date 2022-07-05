package br.com.zup.marvel.domain.usecase

import android.app.Application
import br.com.zup.marvel.data.datasource.local.PersonagemDataBase
import br.com.zup.marvel.domain.model.PersonagemModel
import br.com.zup.marvel.domain.repository.PersonagemRepository
import br.com.zup.marvel.ui.addpersonagem.Personagem
import br.com.zup.marvel.ui.viewstate.ViewState

class PersonagemUseCase(application: Application) {
    private val personagemDAO = PersonagemDataBase.getDatabase(application).personagemDao()
    private val personagemRepository = PersonagemRepository(personagemDAO)

    suspend fun getAllPersonagens(): ViewState<List<PersonagemModel>> {
        return try {
            val personagens = personagemRepository.getAllPersonagens()
            ViewState.Success(personagens)
        } catch (ex: Exception) {
            ViewState.Error(Exception("Não foi possível carregar a lista de personagens!"))
        }
    }

    suspend fun insertPersonagem(personagem: Personagem){
        val personagemModel = PersonagemModel(nome = personagem.nome, descricao = personagem.descricao)
        personagemRepository.insertPersonagem(personagemModel)
    }

}