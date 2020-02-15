package com.example.lyrics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.lyrics.HTTP.SearchConection
import com.example.lyrics.R.layout.act_lyric_display
import kotlinx.android.synthetic.main.act_lyric_display.*
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LyricDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(act_lyric_display)
        val banda = intent.getStringExtra("banda")
        val musga = intent.getStringExtra("musga")
        lifecycleScope.launch {
            val lyricSearchResult = withContext(Dispatchers.IO) {
                SearchConection.searchLyric(banda.toString(), musga.toString())
            }
            if (lyricSearchResult != null) {
                lyricView.text = lyricSearchResult?.lyrics
            } else {
                Log.i("Teste", "Erro: lyricSearchResult retornou vazio")
            }
            /*Toast.makeText(this, banda+musga, Toast.LENGTH_LONG)
            .show()*/

            textBanda.text = banda
            textMusga.text = musga


        }
    }
}
