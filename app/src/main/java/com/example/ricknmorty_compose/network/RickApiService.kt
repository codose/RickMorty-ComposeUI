package com.example.ricknmorty_compose.network

import com.ogie.printfultest.model.RickMorty
import com.ogie.printfultest.model.RickMortyResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface RickApiService {
    @GET("character")
    fun fetchList() : Deferred<RickMortyResponse>

    @GET("character/{id}")
    fun fetchItem(@Path("id") id : Int) : Deferred<RickMorty>
}