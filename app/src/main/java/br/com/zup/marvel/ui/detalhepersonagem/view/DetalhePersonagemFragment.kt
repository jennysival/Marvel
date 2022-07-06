package br.com.zup.marvel.ui.detalhepersonagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import br.com.zup.marvel.CHAVE_PERSONAGEM
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.FragmentDetalhePersonagemBinding
import br.com.zup.marvel.domain.model.PersonagemModel
import br.com.zup.marvel.ui.home.view.HomeActivity

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

        (activity as HomeActivity).supportActionBar?.title = getString(R.string.detalhes_titulo)

        recuperarDadosPersonagem()
    }

    private fun recuperarDadosPersonagem(){
        val personagemModel = arguments?.getParcelable<PersonagemModel>(CHAVE_PERSONAGEM)

        personagemModel?.let {
            binding.tvNomePersonagem.text = it.nome
            binding.tvTextoDescricaoPersonagem.text = it.descricao
        }
    }
}