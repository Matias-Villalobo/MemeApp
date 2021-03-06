package com.example.memeapp.presentation.mvp.contract

import com.example.memeapp.domain.entity.MemesEntity
import io.reactivex.rxjava3.core.Observable

interface MemeAppContract {

    interface MemeAppModel {
        fun getMemesData(): Observable<List<MemesEntity>>
        fun addMemesListToDatabase(memes: List<MemesEntity>)
        fun loadMemesFromDatabase():List<MemesEntity>
    }

    interface MemeAppPresenter {
        fun fetchMemes()
        fun onMemeClicked(memeId: Int)
    }

    interface MemeAppView {
        fun showData(data: List<MemesEntity>)
        fun showError()
        fun showDatabaseError()
        fun showMemeDescriptionError()
        fun showProgressBar(show: Boolean)
        fun showMemeInfo(memeId: Int)
        fun cleanRecycler()
    }
}
