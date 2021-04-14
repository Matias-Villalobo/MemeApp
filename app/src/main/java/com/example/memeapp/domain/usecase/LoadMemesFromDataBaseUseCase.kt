package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDataBase

interface LoadMemesFromDataBaseUseCase {
    fun call(): List<MemesEntity>
}

class LoadMemesFromDataBaseUseCaseImpl(private val localMemeDataBase: LocalMemeDataBase) : LoadMemesFromDataBaseUseCase {
    override fun call(): List<MemesEntity> = localMemeDataBase.loadMemes()
}
