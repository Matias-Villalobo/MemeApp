package com.example.memeapp.data.service.response

import com.google.gson.annotations.SerializedName

class MemesBaseResponse<T>(
    @SerializedName("data") val data: T
)

