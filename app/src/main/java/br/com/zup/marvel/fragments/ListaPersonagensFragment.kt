package br.com.zup.marvel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.marvel.adapter.PersonagemAdapter
import br.com.zup.marvel.databinding.FragmentListaPersonagensBinding
import br.com.zup.marvel.model.Personagem

class ListaPersonagensFragment : Fragment() {
    private lateinit var binding: FragmentListaPersonagensBinding

    private val personagemAdapter: PersonagemAdapter by lazy {
        PersonagemAdapter(arrayListOf())
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

        adicionarPersonagemNaLista()
    }

    private fun exibirRecyclerView(){
        binding.rvRecyclerLista.adapter = personagemAdapter
        binding.rvRecyclerLista.layoutManager = LinearLayoutManager(context)
    }

    fun adicionarPersonagemNaLista(){
        val listaDePersonagens = mutableListOf<Personagem>()

        val vampira = Personagem("Vampira","Vampira é uma mutante Nivel Omega, personagem de histórias em quadrinhos da editora Marvel Comics. Vampira é integrante de algumas equipes dos X-Men e dos Vingadores")
        listaDePersonagens.add(vampira)

        val jessicaJones = Personagem("Jessica Jones","Jessica Campbell Jones-Cage é uma personagem fictícia que aparece nas histórias em quadrinhos publicadas pela Marvel Comics. Jéssica ganhou seus poderes ao sofrer um acidente de carro com a sua família, onde o veículo colidiu com um caminhão de carga radioativa. No incidente toda a sua família morreu e ela ficou durante muito tempo em estado de coma.")
        listaDePersonagens.add(jessicaJones)

        val homemAranha = Personagem("Homem Aranha","O Homem-Aranha, o alter ego de Peter Parker, é um super-herói que aparece nas revistas em quadrinhos publicadas pela Marvel Comics. Criado pelo escritor/editor Stan Lee e pelo escritor/artista Steve Ditko, o Homem-Aranha apareceu pela primeira vez na Amazing Fantasy #15, durante a Era de Prata dos Quadrinhos.")
        listaDePersonagens.add(homemAranha)

        val wolverine = Personagem("Wolverine","Wolverine é um personagem fictício que aparece em quadrinhos americanos publicados pela Marvel Comics, principalmente em associação com os X-Men.")
        listaDePersonagens.add(wolverine)

        val hulk = Personagem("Hulk","O Hulk, por vezes referido como O Incrível Hulk, é um personagem de quadrinhos/banda desenhada do gênero super-herói, propriedade da Marvel Comics, editora pela qual as histórias do personagem são publicadas desde sua criação, na década de 1960.")
        listaDePersonagens.add(hulk)

        val gaviaoArqueiro = Personagem("Gavião Arqueiro","Gavião Arqueiro alter-ego de Clint Barton, é um personagem de quadrinhos americanos da Marvel Comics. Criado por Stan Lee e Don Heck, o herói fez sua primeira aparição em Tales of Suspense #57 antes de se juntar aos Vingadores em Avengers #16. Desde então, Barton tem sido membro proeminente da equipe.")
        listaDePersonagens.add(gaviaoArqueiro)

        val feiticeiraEscarlate = Personagem("Feiticeira Escarlate","Feiticeira Escarlate é uma super-heroína que aparece nos quadrinhos americanos publicados pela Marvel Comics. A personagem foi criada pelo roteirista Stan Lee e pelo desenhista Jack Kirby. Sua primeira aparição foi em \"X-Men\" # 4 na Era de prata das histórias em quadrinhos americanas.")
        listaDePersonagens.add(feiticeiraEscarlate)

        val thor = Personagem("Thor","Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir. Estreando na Era de Prata dos quadrinhos, o personagem apareceu pela primeira vez em Journey into Mystery #83 (agosto de 1962). Ele é um membro fundador da equipe de heróis Vingadores.")
        listaDePersonagens.add(thor)

        val panteraNegra = Personagem("Pantera Negra","Conheça a história de T'Challa, príncipe do reino de Wakanda, que perde o seu pai e viaja para os Estados Unidos, onde tem contato com os Vingadores. Entre as suas habilidades estão a velocidade, inteligência e os sentidos apurados.")
        listaDePersonagens.add(panteraNegra)

        val cavaleiroDaLua = Personagem("Cavaleiro da Lua","O Cavaleiro da Lua é um personagem ficcional das histórias em quadrinhos ou Banda desenhada do Universo Marvel, publicadas pela Marvel Comics. Seu nome verdadeiro é Marc Spector, embora ele se disfarce de outras pessoas para melhor investigar os casos que lhe interessam.")
        listaDePersonagens.add(cavaleiroDaLua)

        personagemAdapter.atualizarLista(listaDePersonagens)
        exibirRecyclerView()
    }
}