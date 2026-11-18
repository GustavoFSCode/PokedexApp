package br.com.escolanovaeratech.listapokemonmock

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
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
        applyWindowInsets(findViewById(R.id.main), rvPokemon)

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

    private fun applyWindowInsets(root: View, recyclerView: RecyclerView) {
        ViewCompat.setOnApplyWindowInsetsListener(root) { view, windowInsets ->
            val insets = windowInsets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            view.updatePadding(left = insets.left, top = insets.top, right = insets.right)
            recyclerView.updatePadding(bottom = insets.bottom)
            windowInsets
        }
    }



}
