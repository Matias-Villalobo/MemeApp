package com.example.memeapp.presentation.mvp.model

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.usecase.GetMemesUseCase
import com.example.memeapp.domain.usecase.LoadMemesFromDatabaseUseCase
import com.example.memeapp.domain.usecase.SaveMemesToDatabaseUseCase
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import io.reactivex.rxjava3.core.Observable

class MemeAppModel(
    private val getMemesUseCase: GetMemesUseCase,
    private val saveMemesToDatabaseUseCase: SaveMemesToDatabaseUseCase,
    private val loadMemesFromDatabaseUseCase: LoadMemesFromDatabaseUseCase
) : MemeAppContract.MemeAppModel {

    override fun getMemesData(): Observable<List<MemesEntity>> =
        getMemesUseCase.getAllMemes()

    override fun addMemesListToDatabase(memes: List<MemesEntity>) {
        saveMemesToDatabaseUseCase.call(memes)
    }

    override fun loadMemesFromDatabase(): List<MemesEntity> =
        loadMemesFromDatabaseUseCase.call()
}
