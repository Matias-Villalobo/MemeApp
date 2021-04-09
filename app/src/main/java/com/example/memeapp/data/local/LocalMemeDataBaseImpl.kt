package com.example.memeapp.data.local


import com.example.memeapp.data.mapper.transformRealmListOfMemes
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDataBase
import io.realm.Realm

class LocalMemeDataBaseImpl() : LocalMemeDataBase {

    override fun saveMemes(memes: List<MemesEntity>) {
        var realmInstance = Realm.getDefaultInstance()

        realmInstance.executeTransaction {
            realmInstance.deleteAll()
            realmInstance.insert(memes.transformRealmListOfMemes())
        }
    }
}
