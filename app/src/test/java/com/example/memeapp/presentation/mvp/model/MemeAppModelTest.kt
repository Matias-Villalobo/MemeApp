package com.example.memeapp.presentation.mvp.model

import com.example.memeapp.domain.usecase.GetMemesUseCase
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class MemeAppModelTest {
    private lateinit var model: MemeAppContract.MemeAppModel
    private val getMemesUseCase: GetMemesUseCase = mock()

    @Before
    fun setup() {
        model = MemeAppModel(getMemesUseCase)
    }

    @Test
    fun `get memes data`() {
        model.getMemesData()
        verify(getMemesUseCase).getAllMemes()
    }
}
