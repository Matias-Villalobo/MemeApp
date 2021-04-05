package com.example.memeapp.presentation.mvp.view

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memeapp.R
import com.example.memeapp.databinding.ActivityMainBinding
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.presentation.adapter.MemesAdapter
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import com.example.memeapp.presentation.mvp.view.base.ActivityView

class MemeAppView(activity: Activity, private val binding: ActivityMainBinding) :
    ActivityView(activity), MemeAppContract.MemeAppView {

    override fun showData(data: List<MemesEntity>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = MemesAdapter(data)
    }

    override fun showError() {
        Toast.makeText(context, R.string.connection_not_established, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }
}
