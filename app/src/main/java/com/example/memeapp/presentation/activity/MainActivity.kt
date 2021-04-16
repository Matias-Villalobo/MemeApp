package com.example.memeapp.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.memeapp.data.local.LocalMemeDatabaseImpl
import com.example.memeapp.data.service.implementation.MemesServiceImpl
import com.example.memeapp.databinding.ActivityMainBinding
import com.example.memeapp.domain.usecase.GetMemesUseCaseImpl
import com.example.memeapp.domain.usecase.LoadMemesFromDatabaseUseCaseImpl
import com.example.memeapp.domain.usecase.SaveMemesToDatabaseUseCaseImpl
import com.example.memeapp.presentation.adapter.ItemClicked
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import com.example.memeapp.presentation.mvp.model.MemeAppModel
import com.example.memeapp.presentation.mvp.presenter.MemeAppPresenter
import com.example.memeapp.presentation.mvp.view.MemeAppView

class MainActivity : AppCompatActivity(), ItemClicked {

    private lateinit var presenter: MemeAppContract.MemeAppPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
        presenter = MemeAppPresenter(
            MemeAppModel
                (
                GetMemesUseCaseImpl(MemesServiceImpl()),
                SaveMemesToDatabaseUseCaseImpl(LocalMemeDatabaseImpl()),
                LoadMemesFromDatabaseUseCaseImpl(LocalMemeDatabaseImpl())
            ),
            MemeAppView(this, binding)
        )
        presenter.fetchMemes()
    }

    override fun memeCardClicked(memeId: Int) {
        presenter.onMemeClicked(memeId)
    }

    private fun setListeners() {
        binding.fab.setOnClickListener { presenter.fetchMemes()}
    }
}
