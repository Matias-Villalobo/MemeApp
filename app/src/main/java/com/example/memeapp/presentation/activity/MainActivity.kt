package com.example.memeapp.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.memeapp.data.local.LocalMemeDataBaseImpl
import com.example.memeapp.data.service.implementation.MemesServiceImpl
import com.example.memeapp.databinding.ActivityMainBinding
import com.example.memeapp.domain.usecase.GetMemesUseCaseImpl
import com.example.memeapp.domain.usecase.LoadMemesFromDataBaseUseCaseImpl
import com.example.memeapp.domain.usecase.SaveMemesToDataBaseUseCaseImpl
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
        loadMemesFromLocalDB()
        presenter = MemeAppPresenter(
            MemeAppModel
                (
                GetMemesUseCaseImpl(MemesServiceImpl()),
                SaveMemesToDataBaseUseCaseImpl(LocalMemeDataBaseImpl()),
                LoadMemesFromDataBaseUseCaseImpl(LocalMemeDataBaseImpl())
            ),
            MemeAppView(this, binding)
        )
        presenter.fetchMemes()
    }

    override fun memeCardClicked(memeId: Int) {
        presenter.onMemeClicked(memeId)
    }

    private fun loadMemesFromLocalDB() {
        binding.fab.setOnClickListener { presenter.getMemesFromDataBase() }
    }
}
