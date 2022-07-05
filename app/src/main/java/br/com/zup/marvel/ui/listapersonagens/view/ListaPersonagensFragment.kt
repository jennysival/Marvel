package br.com.zup.marvel.ui.listapersonagens.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.marvel.CHAVE_PERSONAGEM
import br.com.zup.marvel.R
import br.com.zup.marvel.ui.listapersonagens.view.adapter.PersonagemAdapter
import br.com.zup.marvel.databinding.FragmentListaPersonagensBinding
import br.com.zup.marvel.domain.model.PersonagemModel

class ListaPersonagensFragment : Fragment() {
    private lateinit var binding: FragmentListaPersonagensBinding

    private val personagemAdapter: PersonagemAdapter by lazy {
        PersonagemAdapter(arrayListOf(), this::irParaDetalhePersonagem)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaPersonagensBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adicionarPersonagemNaLista()
    }

    private fun exibirRecyclerView(){
        binding.rvRecyclerLista.adapter = personagemAdapter
        binding.rvRecyclerLista.layoutManager = LinearLayoutManager(context)
    }

    fun adicionarPersonagemNaLista(){
        val listaDePersonagens = mutableListOf<PersonagemModel>()


        personagemAdapter.atualizarLista(listaDePersonagens)
        exibirRecyclerView()
    }

    private fun irParaDetalhePersonagem(personagemModel: PersonagemModel){
        val bundle = bundleOf(CHAVE_PERSONAGEM to personagemModel)

        NavHostFragment.findNavController(this).navigate(R.id.action_listaPersonagensFragment_to_detalhePersonagemFragment, bundle)

    }
}