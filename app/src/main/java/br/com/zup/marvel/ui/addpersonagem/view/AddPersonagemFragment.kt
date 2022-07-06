package br.com.zup.marvel.ui.addpersonagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.marvel.CAMPO_OBRIGATORIO
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.FragmentAddPersonagemBinding
import br.com.zup.marvel.ui.addpersonagem.model.Personagem
import br.com.zup.marvel.ui.addpersonagem.viewmodel.AddPersonagemViewModel
import br.com.zup.marvel.ui.home.view.HomeActivity

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
            if(validarCampos()){
                viewModel.insertPersonagem(recuperarDados())
                Toast.makeText(context, "Cadastro com sucesso!", Toast.LENGTH_LONG).show()
                limparCampos()
            }
        }

        binding.btnVerLista.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_addPersonagemFragment_to_listaPersonagensFragment)
        }
    }

    private fun recuperarDados(): Personagem{
        val nome = binding.etNomePersonagem.text.toString()
        val descricao = binding.etDescricaoPersonagem.text.toString()
        return Personagem(nome, descricao)
    }

    private fun validarCampos(): Boolean{
        if(binding.etNomePersonagem.length() == 0 && binding.etDescricaoPersonagem.length() == 0){
            binding.etNomePersonagem.error = CAMPO_OBRIGATORIO
            binding.etDescricaoPersonagem.error = CAMPO_OBRIGATORIO
            return false
        }

        if(binding.etNomePersonagem.length() == 0){
            binding.etNomePersonagem.error = CAMPO_OBRIGATORIO
            return false
        }

        if(binding.etDescricaoPersonagem.length() == 0){
            binding.etDescricaoPersonagem.error = CAMPO_OBRIGATORIO
            return false
        }

        return true
    }

    private fun limparCampos(){
        binding.etNomePersonagem.text.clear()
        binding.etDescricaoPersonagem.text.clear()
    }

}