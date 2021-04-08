package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDataBase

interface SaveMemesToDataBaseUseCase {
    fun call(memes: List<MemesEntity>)
}

class SaveMemesToDataBaseUseCaseImpl(private val localMemeDataBase: LocalMemeDataBase) :
    SaveMemesToDataBaseUseCase {

    override fun call(memes: List<MemesEntity>) {
        localMemeDataBase.saveMemes(memes)
    }
}
