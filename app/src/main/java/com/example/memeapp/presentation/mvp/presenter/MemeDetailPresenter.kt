package com.example.memeapp.presentation.mvp.presenter

import com.example.memeapp.presentation.mvp.contract.FragmentDetailContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MemeDetailPresenter(
    private val model: FragmentDetailContract.Model,
    private val view: FragmentDetailContract.View
) : FragmentDetailContract.Presenter {

    override fun retrieveSingleMemeInfo(memeId: Int) {
        view.showProgressBar()
        model.getDataSingleMeme(memeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    view.showFragmentData(data)
                    view.hideProgressBar()
                },
                {
                    view.showFragmentError()
                    view.hideProgressBar()
                })
    }
}
