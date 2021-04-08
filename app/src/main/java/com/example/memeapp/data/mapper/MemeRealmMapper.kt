package com.example.memeapp.data.mapper

import com.example.memeapp.data.local.model.MemeRealmEntity
import com.example.memeapp.domain.entity.MemesEntity

object MemeRealmMapper {
    fun transformEntityToRealm(memesEntity: MemesEntity): MemeRealmEntity =
        MemeRealmEntity(
            memesEntity.id,
            memesEntity.bottomText,
            memesEntity.image,
            memesEntity.name,
            memesEntity.tag,
            memesEntity.rank,
            memesEntity.topText
        )

    fun transformRealmListOfMemes(memesRealmList: List<MemesEntity>): List<MemeRealmEntity> =
        memesRealmList.map { transformEntityToRealm(it) }
}
