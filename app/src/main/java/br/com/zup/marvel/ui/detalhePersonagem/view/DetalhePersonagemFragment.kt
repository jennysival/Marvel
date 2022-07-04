package br.com.zup.marvel.ui.detalhePersonagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.marvel.CHAVE_PERSONAGEM
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.FragmentDetalhePersonagemBinding
import br.com.zup.marvel.domain.model.Personagem

class DetalhePersonagemFragment : Fragment() {
    private lateinit var binding: FragmentDetalhePersonagemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalhePersonagemBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recuperarDadosPersonagem()
    }

    private fun recuperarDadosPersonagem(){
        val personagem = arguments?.getParcelable<Personagem>(CHAVE_PERSONAGEM)

        if(personagem != null){
//            binding.tvNomePersonagem.text = personagem.getNome()
//            binding.tvTextoDescricaoPersonagem.text = personagem.getDescricao()
        }
    }
}