package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDatabase
import com.example.memeapp.domain.service.MemesService
import com.example.memeapp.utils.MemesConstantsUtils
import com.example.memeapp.utils.MemesConstantsUtils.ID
import com.example.memeapp.utils.MemesConstantsUtils.MEMES_ENTITY
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Observable
import org.junit.Assert.assertEquals

import org.junit.Before
import org.junit.Test

class GetSingleMemeUseCaseTest {
    private var memesService: MemesService = mock()
    private var memeLocalDatabase: LocalMemeDatabase = mock()
    private var memeObservable: Observable<MemesEntity> = mock()
    private lateinit var getSingleMemeUseCaseImpl: GetSingleMemeUseCaseImpl

    @Before
    fun setUp() {
        getSingleMemeUseCaseImpl = GetSingleMemeUseCaseImpl(memesService, memeLocalDatabase)
    }

    @Test
    fun `test local data base`() {
        whenever(memeLocalDatabase.getSingleMeme(ID)).thenReturn(MEMES_ENTITY)
        getSingleMemeUseCaseImpl.call(ID)
        verify(memeLocalDatabase).getSingleMeme(ID)
    }

    @Test
    fun `test service call`() {
        whenever(memeLocalDatabase.getSingleMeme(ID)).thenReturn(null)
        whenever(memesService.getSingleMeme(ID)).thenReturn(memeObservable)
        val actual = getSingleMemeUseCaseImpl.call(ID)
        verify(memesService).getSingleMeme(ID)
        assertEquals(memeObservable, actual)
    }
}
