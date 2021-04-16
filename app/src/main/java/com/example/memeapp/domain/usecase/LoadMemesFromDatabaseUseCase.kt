package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDatabase

interface LoadMemesFromDatabaseUseCase {
    fun call(): List<MemesEntity>
}

class LoadMemesFromDatabaseUseCaseImpl(private val localMemeDatabase: LocalMemeDatabase) :
    LoadMemesFromDatabaseUseCase {
    override fun call(): List<MemesEntity> = localMemeDatabase.loadMemes()
}
