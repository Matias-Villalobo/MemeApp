package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDatabase
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class SaveMemesToDatabaseUseCaseTest {
    private var localMemeDatabase: LocalMemeDatabase = mock()
    private var memes: List<MemesEntity> = mock()
    private lateinit var saveMemesToDatabaseUseCase: SaveMemesToDatabaseUseCaseImpl

    @Before
    fun setUp() {
        saveMemesToDatabaseUseCase = SaveMemesToDatabaseUseCaseImpl(localMemeDatabase)
    }

    @Test
    fun `verify save character is call`() {
        saveMemesToDatabaseUseCase.call(memes)
        verify(localMemeDatabase).saveMemes(memes)
    }
}
