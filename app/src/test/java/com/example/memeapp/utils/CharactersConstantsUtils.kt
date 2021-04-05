package com.example.memeapp.utils

import com.example.memeapp.data.service.response.MemesResponse
import com.example.memeapp.domain.entity.MemesEntity

object CharactersConstantsUtils {
    const val EMPTY_VALUE = ""
    const val ZERO_VALUE = 0
    const val ONE_VALUE = 1
    const val ID = 1234
    const val BOTTOM_TEXT = "Description"
    const val IMAGE = "Image"
    const val NAME = "MemeName"
    const val TAG = 3
    const val RANK = "3"
    const val TOP_TEXT = "Another description"
    val MEMES_RESPONSE = MemesResponse(ID, BOTTOM_TEXT, IMAGE, NAME, TAG, RANK, TOP_TEXT)
    val MEMES_ENTITY = MemesEntity(ID, BOTTOM_TEXT, IMAGE, NAME, TAG, RANK, TOP_TEXT)

}
