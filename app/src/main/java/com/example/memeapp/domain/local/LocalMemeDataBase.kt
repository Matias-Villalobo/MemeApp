package com.example.memeapp.domain.local

import com.example.memeapp.domain.entity.MemesEntity

interface LocalMemeDataBase {
    fun saveMemes(memes: List<MemesEntity>)
}
