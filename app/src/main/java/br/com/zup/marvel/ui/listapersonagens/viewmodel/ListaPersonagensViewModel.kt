package br.com.zup.marvel.ui.listapersonagens.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.marvel.domain.model.PersonagemModel
import br.com.zup.marvel.domain.usecase.PersonagemUseCase
import br.com.zup.marvel.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaPersonagensViewModel(application: Application): AndroidViewModel(application) {
    private val personagemUseCase = PersonagemUseCase(application)
    val personagemListState = MutableLiveData<ViewState<List<PersonagemModel>>>()

        fun getAllPersonagens() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    personagemUseCase.getAllPersonagens()
                }
                personagemListState.value = response
            } catch (ex: Exception) {
                personagemListState.value =
                    ViewState.Error(Throwable("Não foi possível carregar a lista!"))
            }
        }
    }
}