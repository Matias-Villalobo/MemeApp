package com.example.memeapp.data.local

import com.example.memeapp.data.local.model.MemeRealmEntity
import com.example.memeapp.data.mapper.MemeRealmMapper
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDataBase
import io.realm.Realm

class LocalMemeDataBaseImpl(private val mapper: MemeRealmMapper) : LocalMemeDataBase {

    override fun saveMemes(memes: List<MemesEntity>) {
        var realmInstance = Realm.getDefaultInstance()

        realmInstance.executeTransaction {
            realmInstance.deleteAll()
            var userRealm: List<MemeRealmEntity> = mapper.transformRealmListOfMemes(memes)
            realmInstance.insert(userRealm)
        }
    }
}
