package br.com.zup.marvel.ui.addPersonagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.FragmentAddPersonagemBinding

class AddPersonagemFragment : Fragment() {
    private lateinit var binding: FragmentAddPersonagemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPersonagemBinding.inflate(inflater, container, false)
        return binding.root
    }

}