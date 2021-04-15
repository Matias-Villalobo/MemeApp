package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDatabase
import com.example.memeapp.domain.service.MemesService
import com.example.memeapp.utils.MemesConstantsUtils.ID
import com.example.memeapp.utils.MemesConstantsUtils.ZERO_VALUE
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test

class GetSingleMemeUseCaseTest {
    private var memesService: MemesService = mock()
    private var memeLocalDatabase: LocalMemeDatabase = mock()
    private var meme: Observable<MemesEntity> = mock()
    private var memes: MemesEntity = mock()
    private lateinit var getSingleMemeUseCaseImpl: GetSingleMemeUseCaseImpl

    @Before
    fun setUp() {
        getSingleMemeUseCaseImpl = GetSingleMemeUseCaseImpl(memesService, memeLocalDatabase)
    }

    @Test
    fun `test local data base`(){
        whenever(memeLocalDatabase.getSingleMeme(ID)).thenReturn(memes)
        getSingleMemeUseCaseImpl.call(ID)
        verify(memeLocalDatabase).getSingleMeme(ID)
    }
    @Test
    fun `test local database with a zero value in the id`(){
        whenever(memeLocalDatabase.getSingleMeme(ZERO_VALUE)).thenReturn(memes)
        getSingleMemeUseCaseImpl.call(ZERO_VALUE)
        verify(memeLocalDatabase).getSingleMeme(ZERO_VALUE)
    }

    @Test
    fun `test service call`() {
        whenever(memesService.getSingleMeme(ID)).thenReturn((meme))
        whenever(memeLocalDatabase.getSingleMeme(ID)).thenReturn(memes)
        getSingleMemeUseCaseImpl.call(ID)
        verify(memesService).getSingleMeme(ID)
    }
}
