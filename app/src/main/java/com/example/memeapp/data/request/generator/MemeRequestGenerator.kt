package com.example.memeapp.data.request.generator

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MemeRequestGenerator {
    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S =
        builder.client(httpClient).build().create(serviceClass)

    companion object {
        private const val BASE_URL = "https://alpha-meme-maker.herokuapp.com/"
    }
}
