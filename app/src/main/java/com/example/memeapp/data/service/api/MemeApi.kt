package com.example.memeapp.data.service.api

import com.example.memeapp.data.service.response.MemesBaseResponse
import com.example.memeapp.data.service.response.MemesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MemeApi {
    @GET("{page}")
    fun getMemes(@Path("page") page: Int): Call<MemesBaseResponse<List<MemesResponse>>>

    @GET("/memes/{id}")
    fun getSingleMeme(@Path("id") id: Int): Call<MemesBaseResponse<MemesResponse>> //corregir nombre en memesresponse
}
