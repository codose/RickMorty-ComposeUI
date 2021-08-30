package com.example.ricknmorty_compose.di

import com.example.ricknmorty_compose.network.RickApiService
import com.example.ricknmorty_compose.network.repo.INetworkRepository
import com.example.ricknmorty_compose.network.repo.NetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(repository: NetworkRepositoryImpl) : INetworkRepository

}