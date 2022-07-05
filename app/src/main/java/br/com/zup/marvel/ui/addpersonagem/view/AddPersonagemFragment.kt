package br.com.zup.marvel.ui.addpersonagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.FragmentAddPersonagemBinding
import br.com.zup.marvel.domain.model.PersonagemModel
import br.com.zup.marvel.ui.addpersonagem.viewmodel.AddPersonagemViewModel

class AddPersonagemFragment : Fragment() {

    //TODO: Como eu coloco botão de voltar nos fragmentos?

    private lateinit var binding: FragmentAddPersonagemBinding

    //TODO: Por que usar o by lazy aqui no viewModel ao inves de inicializar direto?
    private val viewModel: AddPersonagemViewModel by lazy {
        ViewModelProvider(this)[AddPersonagemViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPersonagemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCadastrar.setOnClickListener {
            viewModel.insertPersonagem(
                PersonagemModel(
                    nome = binding.etNomePersonagem.text.toString(),
                    descricao = binding.etDescricaoPersonagem.text.toString()
                )
            )
        }

//        initObserver()

        binding.btnVerLista.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_addPersonagemFragment_to_listaPersonagensFragment)
        }
    }

    //TODO: Preciso de ajuda pra implementar o observer
    private fun initObserver() {

    }

}