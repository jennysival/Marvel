package br.com.zup.marvel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.marvel.databinding.PersonagemItemBinding
import br.com.zup.marvel.model.Personagem

class PersonagemAdapter(
    private var listaDePersonagens: MutableList<Personagem>
): RecyclerView.Adapter<PersonagemAdapter.ViewHolder>() {

    class ViewHolder(val binding: PersonagemItemBinding): RecyclerView.ViewHolder(binding.root){
        fun exibirPersonagem(personagem: Personagem){
            binding.tvNomePersonagemLista.text = personagem.getNome()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PersonagemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personagem = listaDePersonagens[position]
        holder.exibirPersonagem(personagem)
    }

    override fun getItemCount(): Int {
        return listaDePersonagens.size
    }

    fun atualizarLista(novaLista: MutableList<Personagem>){
        if (listaDePersonagens.size == 0){
            listaDePersonagens = novaLista
        }else{
            listaDePersonagens.addAll(novaLista)
        }
        notifyDataSetChanged()
    }
}