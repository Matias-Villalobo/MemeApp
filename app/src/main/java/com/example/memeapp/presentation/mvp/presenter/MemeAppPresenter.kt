package com.example.memeapp.presentation.mvp.presenter

import com.example.memeapp.presentation.mvp.contract.MemeAppContract

class MemeAppPresenter(
    private val model : MemeAppContract.MemeAppModel,
    private val view : MemeAppContract.MemeAppView
):MemeAppContract.MemeAppPresenter {
}
