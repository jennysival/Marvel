package br.com.zup.marvel.ui.listapersonagens.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.marvel.databinding.PersonagemItemBinding
import br.com.zup.marvel.domain.model.PersonagemModel

class PersonagemAdapter(
    private var listaDePersonagens: MutableList<PersonagemModel>,
    private val clickPersonagem: (personagemModel: PersonagemModel) -> Unit
): RecyclerView.Adapter<PersonagemAdapter.ViewHolder>() {

    class ViewHolder(val binding: PersonagemItemBinding): RecyclerView.ViewHolder(binding.root){
        fun exibirPersonagem(personagemModel: PersonagemModel){
            binding.tvNomePersonagemLista.text = personagemModel.nome
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PersonagemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personagem = listaDePersonagens[position]
        holder.exibirPersonagem(personagem)
        holder.binding.cvItemLista.setOnClickListener {
            clickPersonagem(personagem)
        }
        holder.exibirPersonagem(personagem)
    }

    override fun getItemCount(): Int {
        return listaDePersonagens.size
    }

    fun atualizarLista(novaLista: List<PersonagemModel>){
        if (listaDePersonagens.size == 0){
            listaDePersonagens = novaLista as MutableList<PersonagemModel>
        }else{
            listaDePersonagens = mutableListOf<PersonagemModel>()
            listaDePersonagens.addAll(novaLista)
        }
        notifyDataSetChanged()
    }
}