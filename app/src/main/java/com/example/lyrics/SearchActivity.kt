package com.example.lyrics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.lyrics.HTTP.SearchConection
import com.example.lyrics.R.layout.act_search
import kotlinx.android.synthetic.main.act_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(act_search)

        var banda = band_name.getText()
        var musga = song_title.getText()



        button.setOnClickListener{
            if (banda.isNullOrEmpty() || musga.isNullOrEmpty()) {
                Toast.makeText(this, "Nome da banda e música devem ser informados.", Toast.LENGTH_LONG)
                    .show()
            } else{
                Log.i("Teste", "A banda inserida pelo usuário foi: $banda")
                Log.i("Teste", "A música inserida pelo usuário foi: $musga")
                Log.i("Teste", "The first step is working... aparently")


                val intent = Intent(this, LyricDisplayActivity::class.java)
                intent.putExtra("banda", banda.toString())
                intent.putExtra("musga", musga.toString())
                //intent.putExtra("lyricSearchResult", lyricSearchResult)
                startActivity(intent)
            }
        }
    }
}
