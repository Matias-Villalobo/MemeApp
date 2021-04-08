package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.service.MemesService
import io.reactivex.rxjava3.core.Observable

interface GetSingleMemeUseCase {
    fun call(id: Int): Observable<MemesEntity>
}

class GetSingleMemeUseCaseImpl constructor(private val memesService: MemesService) :
    GetSingleMemeUseCase {
    override fun call(id: Int): Observable<MemesEntity> = memesService.getSingleMeme(id)
}
