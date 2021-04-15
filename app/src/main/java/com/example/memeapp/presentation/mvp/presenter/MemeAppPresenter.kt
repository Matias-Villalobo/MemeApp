package com.example.memeapp.presentation.mvp.presenter

import com.example.memeapp.data.local.model.MemeRealmEntity
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.realm.Realm

class MemeAppPresenter(
    private val model: MemeAppContract.MemeAppModel,
    private val view: MemeAppContract.MemeAppView
) : MemeAppContract.MemeAppPresenter {

    override fun fetchMemes() {
        view.showProgressBar(true)
        model.getMemesData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    model.addMemesListToDatabase(data)
                    view.showData(data)
                    view.showProgressBar(false)
                },
                {
                    view.showError()
                    view.showProgressBar(false)
                })
    }

    override fun onMemeClicked(memeId: Int) {
        view.showMemeInfo(memeId)
    }

    override fun getMemesFromDatabase() {
        val realm = Realm.getDefaultInstance()
        view.cleanRecycler()
        view.showProgressBar(true)
        if (realm.where(MemeRealmEntity::class.java).findAll().isEmpty()) {
            view.showDatabaseError()
            view.showProgressBar(false)
        } else {
            view.showData(model.loadMemesFromDatabase())
            view.showProgressBar(false)
        }
    }
}
