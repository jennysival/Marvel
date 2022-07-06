package br.com.zup.marvel.ui.addpersonagem.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.marvel.domain.usecase.PersonagemUseCase
import br.com.zup.marvel.ui.addpersonagem.model.Personagem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddPersonagemViewModel(application: Application): AndroidViewModel(application) {

    private val personagemUseCase = PersonagemUseCase(application)

    fun insertPersonagem(personagem: Personagem){

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                personagemUseCase.insertPersonagem(personagem)
            }
        }
    }

}