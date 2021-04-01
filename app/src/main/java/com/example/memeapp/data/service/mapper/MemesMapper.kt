package com.example.memeapp.data.service.mapper

import com.example.memeapp.data.service.response.MemesResponse
import com.example.memeapp.domain.entity.MemesEntity

object MemesMapper {
    fun transformMemes(memesResponse: MemesResponse): MemesEntity =
        MemesEntity(
            memesResponse.id,
            memesResponse.bottomText,
            memesResponse.image,
            memesResponse.name,
            memesResponse.tag,
            memesResponse.rank,
            memesResponse.topText
        )

    fun transformListOfMemes(memesResponse: List<MemesResponse>): List<MemesEntity> =
        memesResponse.map { transformMemes(it) }
}

