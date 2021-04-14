package com.example.memeapp.presentation.mvp.view

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memeapp.R
import com.example.memeapp.databinding.ActivityMainBinding
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.presentation.adapter.ItemClicked
import com.example.memeapp.presentation.adapter.MemesAdapter
import com.example.memeapp.presentation.fragment.MemeFragmentDetail
import com.example.memeapp.presentation.fragment.MemeFragmentDetail.Companion.TAG
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import com.example.memeapp.presentation.mvp.view.base.ActivityView

class MemeAppView(activity: Activity, private val binding: ActivityMainBinding) :
    ActivityView(activity), MemeAppContract.MemeAppView {

    override fun showData(data: List<MemesEntity>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = MemesAdapter(data, (activity as ItemClicked))
    }

    override fun showError() {
        Toast.makeText(context, R.string.connection_not_established, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar(show: Boolean) {
        binding.progressBar.isVisible = show
    }

    override fun showMemeInfo(memeId: Int) {
        MemeFragmentDetail.newInstance(memeId)
            .show((context as FragmentActivity).supportFragmentManager, TAG)
    }

    override fun cleanRecycler() {
        binding.recyclerView.removeAllViewsInLayout()
    }

}
