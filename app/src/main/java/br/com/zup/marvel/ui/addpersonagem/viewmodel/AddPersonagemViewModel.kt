package br.com.zup.marvel.ui.addpersonagem.viewmodel

import androidx.lifecycle.ViewModel
import br.com.zup.marvel.domain.usecase.PersonagemUseCase
import br.com.zup.marvel.ui.addpersonagem.view.Personagem

class AddPersonagemViewModel: ViewModel() {
    private var useCase = PersonagemUseCase()

    fun criarPersonagem(nome: String, descricao: String){

        useCase.adicionarPersonagemUseCase(Personagem(nome,descricao))
    }
}