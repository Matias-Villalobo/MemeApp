package com.example.memeapp.presentation.mvp.model

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.usecase.GetMemesUseCase
import com.example.memeapp.domain.usecase.SaveMemesToDataBaseUseCase
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import io.reactivex.rxjava3.core.Observable

class MemeAppModel(
    private val getMemesUseCase: GetMemesUseCase,
    private val saveMemesToDataBaseUseCase: SaveMemesToDataBaseUseCase
) : MemeAppContract.MemeAppModel {

    override fun getMemesData(): Observable<List<MemesEntity>> =
        getMemesUseCase.getAllMemes()

    override fun addMemesListToDataBase(memes: List<MemesEntity>) {
        saveMemesToDataBaseUseCase.call(memes)
    }
}
