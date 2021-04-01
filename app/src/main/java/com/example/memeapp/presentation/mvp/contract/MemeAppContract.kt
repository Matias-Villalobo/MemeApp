package com.example.memeapp.presentation.mvp.contract

import com.example.memeapp.domain.entity.MemesEntity
import io.reactivex.rxjava3.core.Observable

interface MemeAppContract {

    interface MemeAppModel {
        fun getMemesData(): Observable<List<MemesEntity>>
    }

    interface MemeAppPresenter {
        fun fetchMemes()
    }

    interface MemeAppView {
        fun showData(data: List<MemesEntity>)
        fun showError()
    }
}
