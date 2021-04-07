package com.example.memeapp.data.service.implementation

import com.example.memeapp.data.mapper.MemesMapper
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

    override fun getSingleMeme(id: Int): Observable<MemesEntity> {
        return Observable.create { subscriber ->
            val callResponse = api.createService(MemeApi::class.java).getSingleMeme(id)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val validResponse = response.body()?.data
                validResponse?.let {
                    subscriber.onNext(MemesMapper.transformMemes(it))
                    subscriber.onComplete()
                }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val CHOSEN_PAGE = 1
        private const val ERROR_MESSAGE_EMPTY_RESPONSE =
            "We can not get an answer because of an empty response"
    }
}
