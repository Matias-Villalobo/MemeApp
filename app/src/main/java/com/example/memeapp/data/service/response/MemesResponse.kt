package com.example.memeapp.data.service.response

import com.google.gson.annotations.SerializedName

class MemesResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("bottomText") val bottomText: String,
    @SerializedName("image") val image: String,
    @SerializedName("name") val name: String,
    @SerializedName("tag") val tag: Int,
    @SerializedName("rank") val rank: String,
    @SerializedName("topText") val topText: String
)
