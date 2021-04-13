package com.example.memeapp.presentation.mvp.model

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.usecase.GetMemesUseCase
import com.example.memeapp.domain.usecase.LoadMemesFromDataBaseUseCase
import com.example.memeapp.domain.usecase.SaveMemesToDataBaseUseCase
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class MemeAppModelTest {
    private lateinit var model: MemeAppContract.MemeAppModel
    private val getMemesUseCase: GetMemesUseCase = mock()
    private val saveMemesToDataBaseUseCase: SaveMemesToDataBaseUseCase = mock()
    private val loadMemesFromDataBaseUseCase: LoadMemesFromDataBaseUseCase = mock()
    private var memes: List<MemesEntity> = mock()

    @Before
    fun setup() {
        model = MemeAppModel(getMemesUseCase, saveMemesToDataBaseUseCase, loadMemesFromDataBaseUseCase)
    }

    @Test
    fun `get memes data`() {
        model.getMemesData()
        verify(getMemesUseCase).getAllMemes()
    }

    @Test
    fun `save the memes list in the local data base`() {
        model.addMemesListToDataBase(memes)
        verify(saveMemesToDataBaseUseCase).call(memes)
    }

    @Test
    fun `load the memes from local data base`() {
        model.loadMemesFromDataBase()
        verify(loadMemesFromDataBaseUseCase).call()
    }
}
