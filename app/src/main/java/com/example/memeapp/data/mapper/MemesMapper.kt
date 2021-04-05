package com.example.memeapp.data.mapper

import com.example.memeapp.data.service.response.MemesResponse
import com.example.memeapp.data.utils.ConstUtils.EMPTY_STRING
import com.example.memeapp.domain.entity.MemesEntity

object MemesMapper {
    private fun transformMemes(memesResponse: MemesResponse): MemesEntity =
        MemesEntity(
            memesResponse.id,
            memesResponse.bottomText ?: EMPTY_STRING,
            memesResponse.image,
            memesResponse.name,
            memesResponse.tag,
            memesResponse.rank,
            memesResponse.topText ?: EMPTY_STRING
        )

    fun transformListOfMemes(memesResponse: List<MemesResponse>): List<MemesEntity> =
        memesResponse.map { transformMemes(it) }
}
