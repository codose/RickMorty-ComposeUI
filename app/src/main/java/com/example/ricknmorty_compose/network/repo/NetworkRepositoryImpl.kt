package com.example.ricknmorty_compose.network.repo

import com.example.ricknmorty_compose.network.RickApiService
import com.example.ricknmorty_compose.utils.ApiResponse
import com.ogie.printfultest.model.RickMorty
import com.ogie.printfultest.model.RickMortyResponse
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(private val api: RickApiService) : INetworkRepository {

    override suspend fun fetchList(): ApiResponse<RickMortyResponse> {
        return try {
            val data = api.fetchList().await()
            ApiResponse.Success(data)
        } catch (t: Throwable) {
            ApiResponse.Failure(t.message!!)
        }
    }

    override suspend fun fetchItem(id: Int): ApiResponse<RickMorty> {
        return try {
            val data = api.fetchItem(id).await()
            ApiResponse.Success(data)
        } catch (t: Throwable) {
            ApiResponse.Failure(t.message!!)
        }
    }
}