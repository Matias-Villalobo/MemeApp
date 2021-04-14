package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDataBase
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

class LoadMemesFromDataBaseUseCaseTest {
    private var localMemeDataBase: LocalMemeDataBase = mock()
    private var memes: List<MemesEntity> = mock()

    @Before
    fun setUp() {
        whenever(localMemeDataBase.loadMemes()).thenReturn(memes)
    }

    @Test
    fun `load memes from local database test`() {
        val loadMemesFromDataBase = LoadMemesFromDataBaseUseCaseImpl(localMemeDataBase)
        loadMemesFromDataBase.call()
        verify(localMemeDataBase).loadMemes()
    }
}
