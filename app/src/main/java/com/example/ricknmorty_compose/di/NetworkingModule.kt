package com.example.ricknmorty_compose.di

import com.example.ricknmorty_compose.network.RickApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {

  private const val BASE_URL = "https://rickandmortyapi.com/api/"

  @Provides
  fun provideFactory(): Converter.Factory {
    return GsonConverterFactory.create()
  }


  @Provides
  fun provideClient(): OkHttpClient =
    OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
      })
      .build()



  @Provides
  fun buildRetrofit(client: OkHttpClient, factory: Converter.Factory): Retrofit {
    return Retrofit.Builder()
      .client(client)
      .baseUrl(BASE_URL)
      .addConverterFactory(factory)
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .build()
  }

  @Provides
  fun buildApiService(retrofit: Retrofit): RickApiService =
    retrofit.create(RickApiService::class.java)
}