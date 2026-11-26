package br.com.escolanovaeratech.listapokemonmock

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.escolanovaeratech.listapokemonmock.data.PokemonMock

class DetailAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_acitivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find Pokemon by id
        val pokemonId = intent.getIntExtra(EXTRA_POKEMON_ID, 0)
        val pokemonModel = PokemonMock.findById(pokemonId)

        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
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
