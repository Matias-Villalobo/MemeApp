package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDatabase
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

class LoadMemesFromDatabaseUseCaseTest {
    private var localMemeDatabase: LocalMemeDatabase = mock()
    private var memes: List<MemesEntity> = mock()

    @Before
    fun setUp() {
        whenever(localMemeDatabase.loadMemes()).thenReturn(memes)
    }

    @Test
    fun `load memes from local database test`() {
        val loadMemesFromDatabase = LoadMemesFromDatabaseUseCaseImpl(localMemeDatabase)
        loadMemesFromDatabase.call()
        verify(localMemeDatabase).loadMemes()
    }
}
