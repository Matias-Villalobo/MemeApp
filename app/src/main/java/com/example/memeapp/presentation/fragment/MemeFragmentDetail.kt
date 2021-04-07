package com.example.memeapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.memeapp.data.service.implementation.MemesServiceImpl
import com.example.memeapp.databinding.MemeCardDetailLayoutBinding
import com.example.memeapp.domain.usecase.GetSingleMemeUseCaseImpl
import com.example.memeapp.presentation.mvp.contract.FragmentDetailContract
import com.example.memeapp.presentation.mvp.model.MemeDetailModel
import com.example.memeapp.presentation.mvp.presenter.MemeDetailPresenter
import com.example.memeapp.presentation.mvp.view.MemeDetailView

class MemeFragmentDetail : DialogFragment () {
    private lateinit var presenter: FragmentDetailContract.Presenter
    private lateinit var binding: MemeCardDetailLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = MemeCardDetailLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MemeDetailPresenter(
            MemeDetailModel(
                GetSingleMemeUseCaseImpl(MemesServiceImpl())
            ), MemeDetailView(this, binding)
        )
        presenter.retrieveSingleMemeInfo(
            arguments?.getInt(MEME_ID) ?: ZERO_INT
        )
    }

    companion object {
        const val TAG: String = "MEME_ITEM_FRAGMENT"
        const val MEME_ID: String = "ID"
        const val ZERO_INT = 0

        fun newInstance(memeId: Int): MemeFragmentDetail {
            val args = Bundle()
            args.putInt(MEME_ID, memeId)

            val fragment = MemeFragmentDetail()
            fragment.arguments = args
            return fragment
        }
    }
}
