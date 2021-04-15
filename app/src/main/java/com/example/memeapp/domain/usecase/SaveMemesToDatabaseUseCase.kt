package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDatabase

interface SaveMemesToDatabaseUseCase {
    fun call(memes: List<MemesEntity>)
}

class SaveMemesToDatabaseUseCaseImpl(private val localMemeDatabase: LocalMemeDatabase) :
    SaveMemesToDatabaseUseCase {

    override fun call(memes: List<MemesEntity>) {
        localMemeDatabase.saveMemes(memes)
    }
}
