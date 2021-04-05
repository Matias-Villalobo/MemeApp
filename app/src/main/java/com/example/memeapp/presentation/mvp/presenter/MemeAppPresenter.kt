package com.example.memeapp.presentation.mvp.presenter

import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MemeAppPresenter(
    private val model: MemeAppContract.MemeAppModel,
    private val view: MemeAppContract.MemeAppView
) : MemeAppContract.MemeAppPresenter {

    override fun fetchMemes() {
        view.showProgressBar()
        model.getMemesData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    view.showData(data)
                    view.hideProgressBar()
                },
                {
                    view.showError()
                    view.hideProgressBar()
                })
    }
}
