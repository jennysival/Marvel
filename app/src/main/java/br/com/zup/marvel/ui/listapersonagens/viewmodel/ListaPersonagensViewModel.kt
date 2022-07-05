package br.com.zup.marvel.ui.listapersonagens.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.marvel.domain.model.PersonagemModel
import br.com.zup.marvel.domain.usecase.PersonagemUseCase
import kotlinx.coroutines.launch

class ListaPersonagensViewModel(application: Application): AndroidViewModel(application) {
    private val personagemUseCase = PersonagemUseCase(application)

    private val _listaPersonagens: MutableLiveData<List<PersonagemModel>> = MutableLiveData()
    val listaPersonagens: LiveData<List<PersonagemModel>> = _listaPersonagens

    fun getAllPersonagens(){
        viewModelScope.launch {

            _listaPersonagens.value = personagemUseCase.getAllPersonagens()
        }
    }
}