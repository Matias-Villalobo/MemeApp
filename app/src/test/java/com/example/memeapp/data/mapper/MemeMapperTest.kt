package com.example.memeapp.data.mapper

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.utils.CharactersConstantsUtils.MEMES_ENTITY
import com.example.memeapp.utils.CharactersConstantsUtils.MEMES_RESPONSE
import com.example.memeapp.utils.CharactersConstantsUtils.ONE_VALUE
import com.example.memeapp.utils.CharactersConstantsUtils.ZERO_VALUE
import org.junit.Assert.assertEquals
import org.junit.Test

class MemeMapperTest {

    @Test
    fun `transform list of Memes is Empty Test`() {
        assertEquals(ZERO_VALUE, MemesMapper.transformListOfMemes(emptyList()).size)
    }

    @Test
    fun `transform list of Memes Test`() {
        val memesList = MemesMapper.transformListOfMemes(listOf(MEMES_RESPONSE))
        `assert for valid values for list of Memes`(memesList)
    }

    private fun `assert for valid values for list of Memes`(memesList: List<MemesEntity>) {
        assertEquals(ONE_VALUE, memesList.size)
        for (character in memesList) {
            assertEquals(character, MEMES_ENTITY)
        }
    }
}
