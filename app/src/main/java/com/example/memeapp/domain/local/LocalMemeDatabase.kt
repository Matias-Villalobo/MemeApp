package com.example.memeapp.domain.local

import com.example.memeapp.domain.entity.MemesEntity

interface LocalMemeDatabase {
    fun saveMemes(memes: List<MemesEntity>)
    fun loadMemes():List<MemesEntity>
    fun getSingleMeme(id: Int):MemesEntity
}
