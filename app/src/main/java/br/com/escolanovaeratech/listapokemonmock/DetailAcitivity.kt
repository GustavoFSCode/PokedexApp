package br.com.escolanovaeratech.listapokemonmock

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import br.com.escolanovaeratech.listapokemonmock.data.PokemonMock

class DetailAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.WHITE)
        )
        setContentView(R.layout.activity_detail_acitivity)
        val detailContent = findViewById<View>(R.id.detailContent)
        val contentPaddingBottom = detailContent.paddingBottom
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(left = systemBars.left, top = systemBars.top, right = systemBars.right)
            detailContent.updatePadding(bottom = contentPaddingBottom + systemBars.bottom)
            insets
        }

        // Find Pokemon by id
        val pokemonId = intent.getIntExtra(EXTRA_POKEMON_ID, 0)
        val pokemonModel = PokemonMock.findById(pokemonId)

        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtDescription = findViewById<TextView>(R.id.txtDescription)
        val imgPokemon = findViewById<ImageView>(R.id.imagePokemon)
        val txtHeight = findViewById<TextView>(R.id.txtHeight)
        val txtWeight = findViewById<TextView>(R.id.txtWeight)
        val txtNumber = findViewById<TextView>(R.id.txtNumber)
        val typesContainer = findViewById<LinearLayout>(R.id.typeContainer)
        val main = findViewById<ConstraintLayout>(R.id.main)

        if (pokemonModel != null) {
            txtName.text = pokemonModel.name
            txtDescription.text = pokemonModel.description
            imgPokemon.setImageResource(pokemonModel.imageRes)
            txtHeight.text = pokemonModel.heightMeters.toString()
            txtWeight.text = pokemonModel.weightKg.toString()
            txtNumber.text = pokemonModel.pokedexNumber

            //get main color
            val headerColor = ContextCompat.getColor(this, pokemonModel.types.first().colorRes)
            main.setBackgroundColor(headerColor)


            // Bind types
            val inflater = LayoutInflater.from(this)
            pokemonModel.types.forEach { type ->
                val chip = inflater.inflate(R.layout.view_detail_type_chip, typesContainer, false) as TextView
                chip.text = type.displayName
                val color = ContextCompat.getColor(this, type.colorRes)
                chip.background = chip.background.mutate().also { it.setTint(color) }
                chip.setTextColor(Color.WHITE)
                typesContainer.addView(chip)
            }
        }
    }

    companion object {
        private const val EXTRA_POKEMON_ID = "POKEMON_ID"

        fun createIntent(context: Context, pokemonId: Int): Intent {
            return Intent(context, DetailAcitivity::class.java).apply {
                putExtra(EXTRA_POKEMON_ID, pokemonId)
            }
        }

    }
}
