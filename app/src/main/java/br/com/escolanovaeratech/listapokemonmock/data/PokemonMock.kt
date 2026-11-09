package br.com.escolanovaeratech.listapokemonmock.data

import br.com.escolanovaeratech.listapokemonmock.R
import br.com.escolanovaeratech.listapokemonmock.model.PokemonModel

object PokemonMock {
    val pokemons : List<PokemonModel> = listOf(
        PokemonModel(1, "Bulbasaur", R.drawable.bulbasaur),
        PokemonModel(2, "Charmander", R.drawable.charmander),
        PokemonModel(3, "Squirtle", R.drawable.squirtle),
        PokemonModel(4, "Pikachu", R.drawable.pikachu),
        PokemonModel(5, "Meowth", R.drawable.meowth),
        PokemonModel(6, "Psyduck", R.drawable.psyduck),
        PokemonModel(7, "Gengar", R.drawable.gengar),
        PokemonModel(8, "Eevee", R.drawable.eevee),
        PokemonModel(9, "Snorlax", R.drawable.snorlax)
    )
}