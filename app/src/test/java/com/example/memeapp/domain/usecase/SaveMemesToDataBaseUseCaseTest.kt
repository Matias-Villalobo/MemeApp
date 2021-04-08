package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDataBase
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class SaveMemesToDataBaseUseCaseTest {
    private var localMemeDataBase: LocalMemeDataBase = mock()
    private var memes: List<MemesEntity> = mock()
    private lateinit var saveMemesToDataBaseUseCase: SaveMemesToDataBaseUseCaseImpl

    @Before
    fun setUp() {
        saveMemesToDataBaseUseCase = SaveMemesToDataBaseUseCaseImpl(localMemeDataBase)
    }

    @Test
    fun `verify save character is call`() {
        saveMemesToDataBaseUseCase.call(memes)
        verify(localMemeDataBase).saveMemes(memes)
    }
}
