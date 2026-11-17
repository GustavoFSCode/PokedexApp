package br.com.escolanovaeratech.listapokemonmock.model

import androidx.annotation.ColorRes
import br.com.escolanovaeratech.listapokemonmock.R

enum class PokemonType(
    val displayName: String,
    @param:ColorRes val colorRes: Int,
    @param:ColorRes val headerColorRes: Int,
    val isLightHeader: Boolean
) {
    GRAMA("Grama", R.color.type_grass, R.color.header_grass, true),
    VENENO("Veneno", R.color.type_poison, R.color.header_poison, true),
    FOGO("Fogo", R.color.type_fire, R.color.header_fire, true),
    AGUA("Água", R.color.type_water, R.color.header_water, true),
    ELETRICO("Elétrico", R.color.type_electric, R.color.header_electric, true),
    NORMAL("Normal", R.color.type_normal, R.color.header_normal, true),
    FANTASMA("Fantasma", R.color.type_ghost, R.color.header_ghost, false)
}