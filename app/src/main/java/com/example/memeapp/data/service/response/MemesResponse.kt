package com.example.memeapp.data.service.response

import com.example.memeapp.data.utils.ConstUtils.EMPTY_STRING
import com.google.gson.annotations.SerializedName

class MemesResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("bottomText") val bottomText: String? = EMPTY_STRING,
    @SerializedName("image") val image: String,
    @SerializedName("name") val name: String,
    @SerializedName("tag") val tag: Int,
    @SerializedName("rank") val rank: String,
    @SerializedName("topText") val topText: String? = EMPTY_STRING
)
