package com.example.memeapp.data.mapper

import com.example.memeapp.data.local.model.MemeRealmEntity
import com.example.memeapp.domain.entity.MemesEntity

object MemeRealmMapper {

    fun List<MemesEntity>.transformRealmListOfMemes(): List<MemeRealmEntity> =
        this.map { it.transformEntityToRealm() }

    fun MemesEntity.transformEntityToRealm(): MemeRealmEntity =
        MemeRealmEntity(
            this.id,
            this.bottomText,
            this.image,
            this.name,
            this.tag,
            this.rank,
            this.topText
        )
}
