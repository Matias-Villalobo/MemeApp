package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.service.MemesService
import io.reactivex.rxjava3.core.Observable

interface GetMemesUseCase {
    fun getAllMemes(): Observable<List<MemesEntity>>
}

class GetMemesUseCaseImpl constructor(private val memesService: MemesService) : GetMemesUseCase {
    override fun getAllMemes(): Observable<List<MemesEntity>> = memesService.getMemes()
}
