package com.example.memeapp.data.local


import com.example.memeapp.data.local.model.MemeRealmEntity
import com.example.memeapp.data.mapper.transformRealmListOfMemes
import com.example.memeapp.data.mapper.transformRealmListToEntityList
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDataBase
import io.realm.Realm

class LocalMemeDataBaseImpl() : LocalMemeDataBase {

    override fun saveMemes(memes: List<MemesEntity>) {
        val realmInstance = Realm.getDefaultInstance()
        realmInstance.executeTransaction {
            realmInstance.deleteAll()
            realmInstance.insert(memes.transformRealmListOfMemes())
        }
    }

    override fun loadMemes(): List<MemesEntity> {
        val realm = Realm.getDefaultInstance()
        val memesRealm = realm.where(MemeRealmEntity::class.java).findAll()
        return memesRealm.transformRealmListToEntityList()
    }
}
