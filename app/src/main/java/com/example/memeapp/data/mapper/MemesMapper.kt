package com.example.memeapp.data.mapper

import com.example.memeapp.data.service.response.MemeResponse
import com.example.memeapp.data.utils.ConstUtils.EMPTY_STRING
import com.example.memeapp.domain.entity.MemesEntity

object MemesMapper {
    fun MemeResponse.transformMemes(): MemesEntity =
        MemesEntity(
            this.id,
            this.bottomText ?: EMPTY_STRING,
            this.image,
            this.name,
            this.tag ?: EMPTY_STRING,
            this.rank,
            this.topText ?: EMPTY_STRING
        )

    fun List<MemeResponse>.transformListOfMemes(): List<MemesEntity> =
        this.map { it.transformMemes() }
}
