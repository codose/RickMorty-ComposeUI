package com.example.ricknmorty_compose.network.repo

import com.example.ricknmorty_compose.utils.ApiResponse
import com.ogie.printfultest.model.RickMorty
import com.ogie.printfultest.model.RickMortyResponse

interface INetworkRepository {
    suspend fun fetchList() : ApiResponse<RickMortyResponse>
    suspend fun fetchItem(id : Int) : ApiResponse<RickMorty>
}