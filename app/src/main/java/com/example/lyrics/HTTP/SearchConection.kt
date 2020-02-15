package com.example.lyrics.HTTP

import android.util.Log
import com.example.lyrics.ResultantLyric
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.util.concurrent.TimeUnit


object SearchConection {

    private const val urlBegin = "https://api.lyrics.ovh/v1/"
    private val client = OkHttpClient.Builder()
        .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build()
    
    fun searchLyric(b:String,m: String): ResultantLyric?{
        val urlFull = urlBegin + b + "/" +m
        val request = Request.Builder()
            .url(String.format(urlFull))
            .build()
        Log.i("Teste", "url da request $request")
        try{
            val response = client.newCall(request).execute()
            //Log.i("Teste", response.body?.string())
            val json = response.body?.string()
            Log.i("Json", "$json")
            val result = Gson().fromJson<ResultantLyric>(
                json,ResultantLyric::class.java
            )
            Log.i("Teste", json)
            return result
        } catch (e: Exception){
            e.printStackTrace()
            Log.i("Teste", "exception")
        }
        return null
    }


}