package com.example.memeapp.utils

import com.example.memeapp.data.local.model.MemeRealmEntity
import com.example.memeapp.data.service.response.MemeResponse
import com.example.memeapp.domain.entity.MemesEntity

object MemesConstantsUtils {
    const val EMPTY_VALUE = ""
    const val ZERO_VALUE = 0
    const val ONE_VALUE = 1
    const val ID = 1234
    const val BOTTOM_TEXT = "Description"
    const val IMAGE = "Image"
    const val NAME = "MemeName"
    const val RANK = 3
    const val TAG = "3"
    const val TOP_TEXT = "Another description"
    val MEMES_RESPONSE = MemeResponse(ID, BOTTOM_TEXT, IMAGE, NAME, TAG, RANK, TOP_TEXT)
    val MEMES_ENTITY = MemesEntity(ID, BOTTOM_TEXT, IMAGE, NAME, TAG, RANK, TOP_TEXT)
    val MEMES_REALM_ENTITY = MemeRealmEntity(ID, BOTTOM_TEXT, IMAGE, NAME, TAG, RANK, TOP_TEXT)
    val MEMES_NULL_RESPONSE = MemeResponse(ID, null, IMAGE, NAME, null, RANK, null)
    val MEMES_NULL_ENTITY = MemesEntity(ID, EMPTY_VALUE, IMAGE, NAME, EMPTY_VALUE, RANK, EMPTY_VALUE)
}
