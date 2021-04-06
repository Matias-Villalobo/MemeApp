package com.example.memeapp.data.service.implementation

import com.example.memeapp.data.request.generator.MemeRequestGenerator
import com.example.memeapp.data.service.api.MemeApi
import com.example.memeapp.data.mapper.MemesMapper.transformListOfMemes
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.domain.service.MemesService
import io.reactivex.rxjava3.core.Observable

class MemesServiceImpl : MemesService {

    private val api: MemeRequestGenerator = MemeRequestGenerator()

    override fun getMemes(): Observable<List<MemesEntity>> {
        return Observable.create { subscriber ->
            val callResponse = api.createService(MemeApi::class.java).getMemes(CHOSEN_PAGE)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                subscriber.onNext(response.body()?.data?.let { transformListOfMemes(it) })
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val CHOSEN_PAGE = 1
    }
}
