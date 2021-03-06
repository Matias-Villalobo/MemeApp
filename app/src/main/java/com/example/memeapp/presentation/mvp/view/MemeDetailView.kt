package com.example.memeapp.presentation.mvp.view

import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.memeapp.R
import com.example.memeapp.databinding.MemeCardDetailLayoutBinding
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.presentation.mvp.contract.FragmentDetailContract
import com.example.memeapp.presentation.mvp.view.base.FragmentView

class MemeDetailView(
    fragment: DialogFragment,
    private val binding: MemeCardDetailLayoutBinding
) : FragmentDetailContract.View,
    FragmentView(fragment) {

    override fun showFragmentData(data: MemesEntity) {
        this.context?.let {
            Glide.with(it)
                .load(data.image)
                .into(binding.memeImage)
        }
        binding.memeName.text = data.name
        binding.memeButtonTextDescription.text = data.bottomText
        binding.memeTopTextDescription.text = data.topText
        binding.memeTagsDescription.text = data.tag
        binding.memeRankDescription.text = data.rank.toString()
    }

    override fun showFragmentError() {
        Toast.makeText(context, R.string.no_meme_description, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar(show: Boolean) {
        binding.progressBar.isInvisible = show.not()
        binding.memeRankTitle.isInvisible = show
        binding.memeButtonTextTitle.isInvisible = show
        binding.memeTopTextTitle.isInvisible = show
        binding.memeTagsTitle.isInvisible = show
        binding.memeRankTitle.isInvisible = show
    }

}
