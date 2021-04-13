package com.example.memeapp.data.mapper

import com.example.memeapp.data.local.model.MemeRealmEntity
import com.example.memeapp.data.service.response.MemeResponse
import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.utils.MemesConstantsUtils
import com.example.memeapp.utils.MemesConstantsUtils.MEMES_ENTITY
import com.example.memeapp.utils.MemesConstantsUtils.MEMES_NULL_ENTITY
import com.example.memeapp.utils.MemesConstantsUtils.MEMES_NULL_RESPONSE
import com.example.memeapp.utils.MemesConstantsUtils.MEMES_REALM_ENTITY
import com.example.memeapp.utils.MemesConstantsUtils.MEMES_RESPONSE
import com.example.memeapp.utils.MemesConstantsUtils.ONE_VALUE
import com.example.memeapp.utils.MemesConstantsUtils.ZERO_VALUE
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

    @Test
    fun `transform memes entity to realm Test`() {
        val meme = MEMES_ENTITY.transformEntityToRealm()
        assertEquals(MemesConstantsUtils.ID, meme.id)
        assertEquals(MemesConstantsUtils.NAME, meme.name)
        assertEquals(MemesConstantsUtils.BOTTOM_TEXT, meme.bottomText)
        assertEquals(MemesConstantsUtils.IMAGE, meme.image)
        assertEquals(MemesConstantsUtils.TAG, meme.tag)
        assertEquals(MemesConstantsUtils.RANK, meme.rank)
        assertEquals(MemesConstantsUtils.TOP_TEXT, meme.topText)
    }

    @Test
    fun `transform list of memes entity to realm list Test`() {
        assertEquals(ZERO_VALUE, emptyList<MemesEntity>().transformRealmListOfMemes().size)
    }

    @Test
    fun `transform memes realm to entity Test`() {
        val meme = MEMES_REALM_ENTITY.transformRealmToEntity()
        assertEquals(MemesConstantsUtils.ID, meme.id)
        assertEquals(MemesConstantsUtils.NAME, meme.name)
        assertEquals(MemesConstantsUtils.BOTTOM_TEXT, meme.bottomText)
        assertEquals(MemesConstantsUtils.IMAGE, meme.image)
        assertEquals(MemesConstantsUtils.TAG, meme.tag)
        assertEquals(MemesConstantsUtils.RANK, meme.rank)
        assertEquals(MemesConstantsUtils.TOP_TEXT, meme.topText)
    }

    @Test
    fun `transform list of realm to list of entity Test`() {
        assertEquals(ZERO_VALUE, emptyList<MemeRealmEntity>().transformRealmListToEntityList().size)
    }

    private fun `assert for valid values for list of Memes`(memesList: List<MemesEntity>) {
        assertEquals(ONE_VALUE, memesList.size)
        for (character in memesList) {
            assertEquals(character, MEMES_ENTITY)
        }
    }
}
