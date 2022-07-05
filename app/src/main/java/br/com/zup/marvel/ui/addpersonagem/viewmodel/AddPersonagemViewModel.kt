package br.com.zup.marvel.ui.addpersonagem.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.marvel.domain.model.PersonagemModel
import br.com.zup.marvel.domain.usecase.PersonagemUseCase
import kotlinx.coroutines.launch

class AddPersonagemViewModel(application: Application): AndroidViewModel(application) {
//TODO: Por que esse view model precisa ser AndroidViewModel especificamente?

    private val personagemUseCase = PersonagemUseCase(application)

    fun insertPersonagem(personagem: PersonagemModel){
        //TODO: O que é esse viewModelScope.launch?
        //TODO: Como eu trato as exceptions nesse caso?
            personagemUseCase.insertPersonagem(personagem)
    }

}