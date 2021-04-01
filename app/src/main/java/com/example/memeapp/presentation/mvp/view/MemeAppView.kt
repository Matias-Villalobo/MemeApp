package com.example.memeapp.presentation.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.memeapp.R
import com.example.memeapp.databinding.ActivityMainBinding
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import com.example.memeapp.presentation.mvp.view.base.ActivityView

class MemeAppView(activity: Activity, private val binding: ActivityMainBinding) :
    ActivityView(activity), MemeAppContract.MemeAppView {

    override fun showData(data: List<MemesEntity>) {
        Toast.makeText(context, R.string.connection_established, Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        Toast.makeText(context, R.string.connection_not_established, Toast.LENGTH_SHORT).show()
    }
}
