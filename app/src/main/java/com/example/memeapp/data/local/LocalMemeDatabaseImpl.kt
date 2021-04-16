package com.example.memeapp.data.local

import com.example.memeapp.data.local.model.MemeRealmEntity
import com.example.memeapp.data.mapper.transformRealmListOfMemes
import com.example.memeapp.data.mapper.transformRealmListToEntityList
import com.example.memeapp.data.mapper.transformRealmToEntity
import com.example.memeapp.data.utils.ConstUtils.EMPTY_STRING
import com.example.memeapp.data.utils.ConstUtils.ZERO_VALUE
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDatabase
import io.realm.Realm

class LocalMemeDatabaseImpl() : LocalMemeDatabase {

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

    override fun getSingleMeme(id: Int): MemesEntity? {
        val realm = Realm.getDefaultInstance()
        val memesRealm = (realm.where(MemeRealmEntity::class.java).equalTo(ID, id)
            .findFirst())?.transformRealmToEntity()
        return memesRealm
    }

    companion object {
        private const val ID = "id"
    }
}
