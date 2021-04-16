package com.example.memeapp.presentation.mvp.model

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.usecase.GetMemesUseCase
import com.example.memeapp.domain.usecase.LoadMemesFromDatabaseUseCase
import com.example.memeapp.domain.usecase.SaveMemesToDatabaseUseCase
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class MemeAppModelTest {
    private lateinit var model: MemeAppContract.MemeAppModel
    private val getMemesUseCase: GetMemesUseCase = mock()
    private val saveMemesToDatabaseUseCase: SaveMemesToDatabaseUseCase = mock()
    private val loadMemesFromDatabaseUseCase: LoadMemesFromDatabaseUseCase = mock()
    private var memes: List<MemesEntity> = mock()

    @Before
    fun setup() {
        model = MemeAppModel(getMemesUseCase, saveMemesToDatabaseUseCase, loadMemesFromDatabaseUseCase)
    }

    @Test
    fun `get memes data`() {
        model.getMemesData()
        verify(getMemesUseCase).getAllMemes()
    }

    @Test
    fun `save the memes list in the local data base`() {
        model.addMemesListToDatabase(memes)
        verify(saveMemesToDatabaseUseCase).call(memes)
    }

    @Test
    fun `load the memes from local data base`() {
        model.loadMemesFromDatabase()
        verify(loadMemesFromDatabaseUseCase).call()
    }
}
