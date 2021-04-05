package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.service.MemesService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test

class GetMemesUseCaseTest {
    private var memesService: MemesService = mock()
    private var memes: List<MemesEntity> = mock()
    private lateinit var getMemesUseCaseImpl: GetMemesUseCaseImpl

    @Before
    fun setUp() {
        getMemesUseCaseImpl = GetMemesUseCaseImpl(memesService)
    }

    @Test
    fun `get memes Test`() {
        getMemesUseCaseImpl.getAllMemes()
        whenever(memesService.getMemes()).thenReturn(Observable.just(memes))
        verify(memesService).getMemes()
    }
}
