package com.example.memeapp.presentation.mvp.model

import com.example.memeapp.domain.usecase.GetSingleMemeUseCase
import com.example.memeapp.presentation.mvp.contract.FragmentDetailContract
import com.example.memeapp.utils.CharactersConstantsUtils.ID
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class MemeDetailModelTest {
    private lateinit var model: FragmentDetailContract.Model
    private val getSingleMemeUseCase: GetSingleMemeUseCase = mock()

    @Before
    fun setup() {
        model = MemeDetailModel(getSingleMemeUseCase)
    }

    @Test
    fun `get single character data`() {
        model.getDataSingleMeme(ID)
        verify(getSingleMemeUseCase).call(ID)
    }
}
