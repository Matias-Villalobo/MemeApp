package com.example.memeapp.data.mapper

import com.example.memeapp.data.local.model.MemeRealmEntity
import com.example.memeapp.data.service.response.MemeResponse
import com.example.memeapp.data.utils.ConstUtils
import com.example.memeapp.domain.entity.MemesEntity

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

fun MemeResponse.transformMemes(): MemesEntity =
    MemesEntity(
        this.id,
        this.bottomText ?: ConstUtils.EMPTY_STRING,
        this.image,
        this.name,
        this.tag ?: ConstUtils.EMPTY_STRING,
        this.rank,
        this.topText ?: ConstUtils.EMPTY_STRING
    )

fun List<MemeResponse>.transformListOfMemes(): List<MemesEntity> =
    this.map { it.transformMemes() }
