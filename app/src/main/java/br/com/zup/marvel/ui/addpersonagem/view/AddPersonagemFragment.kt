package br.com.zup.marvel.ui.addpersonagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.FragmentAddPersonagemBinding
import br.com.zup.marvel.ui.addpersonagem.viewmodel.AddPersonagemViewModel

class AddPersonagemFragment : Fragment() {
    private lateinit var binding: FragmentAddPersonagemBinding

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

        }

        binding.btnVerLista.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_addPersonagemFragment_to_listaPersonagensFragment)
        }
    }

}