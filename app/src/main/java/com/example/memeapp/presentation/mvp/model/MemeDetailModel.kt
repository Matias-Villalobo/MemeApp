package com.example.memeapp.presentation.mvp.model

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.usecase.GetSingleMemeUseCase
import com.example.memeapp.presentation.mvp.contract.FragmentDetailContract
import io.reactivex.rxjava3.core.Observable

class MemeDetailModel (private val getSingleMemeUseCase: GetSingleMemeUseCase) :
    FragmentDetailContract.Model {

    override fun getDataSingleMeme(memeId: Int): Observable<MemesEntity> =
        getSingleMemeUseCase.call(memeId)
}
