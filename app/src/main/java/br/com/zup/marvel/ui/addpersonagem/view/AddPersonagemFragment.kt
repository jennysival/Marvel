package br.com.zup.marvel.ui.addpersonagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.FragmentAddPersonagemBinding
import br.com.zup.marvel.domain.model.PersonagemModel
import br.com.zup.marvel.ui.addpersonagem.Personagem
import br.com.zup.marvel.ui.addpersonagem.viewmodel.AddPersonagemViewModel

class AddPersonagemFragment : Fragment() {

    private lateinit var binding: FragmentAddPersonagemBinding

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
            val nome = binding.etNomePersonagem.text.toString()
            val descricao = binding.etDescricaoPersonagem.text.toString()
            val personagem = Personagem(nome, descricao)
            viewModel.insertPersonagem(personagem)
            Toast.makeText(context, "Cadastro com sucesso!", Toast.LENGTH_LONG).show()
        }

        binding.btnVerLista.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_addPersonagemFragment_to_listaPersonagensFragment)
        }
    }

}