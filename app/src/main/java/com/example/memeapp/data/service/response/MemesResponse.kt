package com.example.memeapp.data.service.response

import com.example.memeapp.data.utils.ConstUtils.EMPTY_STRING
import com.google.gson.annotations.SerializedName

class MemesResponse(
    @SerializedName("ID") val id: Int,
    @SerializedName("bottomText") val bottomText: String? = EMPTY_STRING,
    @SerializedName("image") val image: String,
    @SerializedName("name") val name: String,
    @SerializedName("tags") val tag: String? = EMPTY_STRING,
    @SerializedName("rank") val rank: Int,
    @SerializedName("topText") val topText: String? = EMPTY_STRING
)
