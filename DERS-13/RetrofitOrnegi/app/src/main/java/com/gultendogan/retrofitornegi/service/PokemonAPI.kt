package com.gultendogan.retrofitornegi.service

import com.gultendogan.retrofitornegi.model.PokemonModel
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface PokemonAPI {

    //https://raw.githubusercontent.com/gulten27/SimplePokemonApi/main/pokemon.json

    @GET("gulten27/SimplePokemonApi/main/pokemon.json")
    fun getData(): Observable<List<PokemonModel>>

}