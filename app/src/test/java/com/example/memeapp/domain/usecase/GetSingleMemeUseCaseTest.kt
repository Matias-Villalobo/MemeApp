package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.service.MemesService
import com.example.memeapp.utils.CharactersConstantsUtils.ID
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test

class GetSingleMemeUseCaseTest {
    private var memesService: MemesService = mock()
    private var meme: MemesEntity = mock()
    private lateinit var getSingleMemeUseCaseImpl : GetSingleMemeUseCaseImpl

    @Before
    fun setUp() {
        getSingleMemeUseCaseImpl= GetSingleMemeUseCaseImpl(memesService)
    }

    @Test
    fun call() {
        getSingleMemeUseCaseImpl.call(ID)
        whenever(memesService.getSingleMeme(ID)).thenReturn(Observable.just(meme))
        verify(memesService).getSingleMeme(ID)
    }
}
