package com.example.memeapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.memeapp.R
import com.example.memeapp.databinding.MemeCardLayoutBinding
import com.example.memeapp.domain.entity.MemesEntity

class MemesAdapter(private val meme: List<MemesEntity>) :
    RecyclerView.Adapter<MemesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.meme_card_layout, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(meme[position])
    }

    override fun getItemCount() = meme.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = MemeCardLayoutBinding.bind(itemView)

        fun bind(memeItem: MemesEntity) {
            binding.apply {
                memeName.text = memeItem.name
                Glide.with(itemView.context)
                    .load(memeItem.image)
                    .into(image)
            }
        }
    }

}
