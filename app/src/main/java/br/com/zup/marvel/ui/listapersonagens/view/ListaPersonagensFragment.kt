package br.com.zup.marvel.ui.listapersonagens.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.marvel.CHAVE_PERSONAGEM
import br.com.zup.marvel.R
import br.com.zup.marvel.ui.listapersonagens.view.adapter.PersonagemAdapter
import br.com.zup.marvel.databinding.FragmentListaPersonagensBinding
import br.com.zup.marvel.domain.model.PersonagemModel
import br.com.zup.marvel.ui.listapersonagens.viewmodel.ListaPersonagensViewModel
import br.com.zup.marvel.ui.viewstate.ViewState

class ListaPersonagensFragment : Fragment() {
    private lateinit var binding: FragmentListaPersonagensBinding

    private val personagemAdapter: PersonagemAdapter by lazy {
        PersonagemAdapter(arrayListOf(), this::irParaDetalhePersonagem)
    }

    private val viewModel: ListaPersonagensViewModel by lazy {
        ViewModelProvider(this)[ListaPersonagensViewModel::class.java]
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
        initObserver()
        exibirRecyclerView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAllPersonagens()
    }

    private fun exibirRecyclerView(){
        binding.rvRecyclerLista.adapter = personagemAdapter
        binding.rvRecyclerLista.layoutManager = LinearLayoutManager(context)
    }

    private fun irParaDetalhePersonagem(personagemModel: PersonagemModel){
        val bundle = bundleOf(CHAVE_PERSONAGEM to personagemModel)

        NavHostFragment.findNavController(this).navigate(R.id.action_listaPersonagensFragment_to_detalhePersonagemFragment, bundle)

    }

    private fun initObserver(){
        viewModel.personagemListState.observe(this.viewLifecycleOwner){
            when (it) {
                is ViewState.Success -> {
                    personagemAdapter.atualizarLista(it.data)
                }
                is ViewState.Error -> {
                    Toast.makeText(
                        context,
                        "${it.throwable.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {}
            }
        }
    }
}