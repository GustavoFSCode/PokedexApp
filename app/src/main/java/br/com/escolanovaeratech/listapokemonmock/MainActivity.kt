package br.com.escolanovaeratech.listapokemonmock

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.escolanovaeratech.listapokemonmock.adapter.PokemonAdapter
import br.com.escolanovaeratech.listapokemonmock.data.PokemonMock

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //Recuperar a recycler view
        val rvPokemon = findViewById<RecyclerView>(R.id.rvPokemon)
        applyWindowInsets(rvPokemon)

        // Criar adapter
        val adapter = PokemonAdapter{ clickedPokemon ->
            //Abrir tela de detalhes
            val intent = DetailAcitivity.createIntent(this, clickedPokemon.id)
            startActivity(intent)
        }

        //Conectar o recyclerView com o adapter
        rvPokemon.adapter = adapter

        //Enviar lista de pokemons para o adapter
        adapter.submitList(PokemonMock.pokemons)
    }

    private fun applyWindowInsets(recyclerView: RecyclerView){
        ViewCompat.setOnApplyWindowInsetsListener(recyclerView){ view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom)
            windowInsets
        }
    }



}
