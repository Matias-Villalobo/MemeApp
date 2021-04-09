package com.example.memeapp.data.mapper

import com.example.memeapp.data.service.response.MemeResponse
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.utils.CharactersConstantsUtils.MEMES_ENTITY
import com.example.memeapp.utils.CharactersConstantsUtils.MEMES_NULL_ENTITY
import com.example.memeapp.utils.CharactersConstantsUtils.MEMES_NULL_RESPONSE
import com.example.memeapp.utils.CharactersConstantsUtils.MEMES_RESPONSE
import com.example.memeapp.utils.CharactersConstantsUtils.ONE_VALUE
import com.example.memeapp.utils.CharactersConstantsUtils.ZERO_VALUE
import org.junit.Assert.assertEquals
import org.junit.Test

class MemeMapperTest {

    @Test
    fun `transform list of Memes is Empty Test`() {
        assertEquals(ZERO_VALUE, emptyList<MemeResponse>().transformListOfMemes().size)
    }

    @Test
    fun `transform list of Memes Test`() {
        val memesList = listOf(MEMES_RESPONSE).transformListOfMemes()
        `assert for valid values for list of Memes`(memesList)
    }

    @Test
    fun `invalid Value for Memes Test`() {
        val actual = MEMES_NULL_RESPONSE.transformMemes()
        assertEquals(actual, MEMES_NULL_ENTITY)
    }

    @Test
    fun `valid Value for Memes Test`() {
        val actual = MEMES_RESPONSE.transformMemes()
        assertEquals(actual, MEMES_ENTITY)
    }

    private fun `assert for valid values for list of Memes`(memesList: List<MemesEntity>) {
        assertEquals(ONE_VALUE, memesList.size)
        for (character in memesList) {
            assertEquals(character, MEMES_ENTITY)
        }
    }
}
