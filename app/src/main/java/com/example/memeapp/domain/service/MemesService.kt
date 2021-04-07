package com.example.memeapp.domain.service

import com.example.memeapp.domain.entity.MemesEntity
import io.reactivex.rxjava3.core.Observable

interface MemesService {
    fun getMemes(): Observable<List<MemesEntity>>
    fun getSingleMeme(id: Int): Observable<MemesEntity>
}
