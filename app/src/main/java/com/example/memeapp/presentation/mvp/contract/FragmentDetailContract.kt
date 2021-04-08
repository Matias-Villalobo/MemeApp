package com.example.memeapp.presentation.mvp.contract

import com.example.memeapp.domain.entity.MemesEntity
import io.reactivex.rxjava3.core.Observable

interface FragmentDetailContract {
    interface Model {
        fun getDataSingleMeme(memeId: Int): Observable<MemesEntity>
    }

    interface View {
        fun showFragmentData(data: MemesEntity)
        fun showFragmentError()
        fun showProgressBar(show: Boolean)

    }

    interface Presenter {
        fun retrieveSingleMemeInfo(memeId: Int)
    }
}
