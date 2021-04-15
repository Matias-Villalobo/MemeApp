package com.example.memeapp.domain.usecase

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.local.LocalMemeDatabase
import com.example.memeapp.domain.service.MemesService
import io.reactivex.rxjava3.core.Observable
import com.example.memeapp.data.utils.ConstUtils.ZERO_VALUE

interface GetSingleMemeUseCase {
    fun call(id: Int): Observable<MemesEntity>
}

class GetSingleMemeUseCaseImpl constructor(
    private val memesService: MemesService,
    private val localDatabase: LocalMemeDatabase
) : GetSingleMemeUseCase {
    override fun call(id: Int): Observable<MemesEntity> {
        val localMeme = localDatabase.getSingleMeme(id)
        return if (localMeme.id == ZERO_VALUE) {
            memesService.getSingleMeme(id)
        } else {
            Observable.just(localMeme)
        }
    }
}
