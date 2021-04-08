package com.example.memeapp.data.mapper

import com.example.memeapp.utils.CharactersConstantsUtils
import com.example.memeapp.utils.CharactersConstantsUtils.BOTTOM_TEXT
import com.example.memeapp.utils.CharactersConstantsUtils.ID
import com.example.memeapp.utils.CharactersConstantsUtils.IMAGE
import com.example.memeapp.utils.CharactersConstantsUtils.MEMES_ENTITY
import com.example.memeapp.utils.CharactersConstantsUtils.NAME
import com.example.memeapp.utils.CharactersConstantsUtils.RANK
import com.example.memeapp.utils.CharactersConstantsUtils.TAG
import com.example.memeapp.utils.CharactersConstantsUtils.TOP_TEXT
import com.example.memeapp.utils.CharactersConstantsUtils.ZERO_VALUE
import org.junit.Assert.assertEquals
import org.junit.Test

class MemeRealmMapperTest {

    @Test
    fun `transform memes entity to realm Test`() {
        val meme = MemeRealmMapper.transformEntityToRealm(MEMES_ENTITY)
        assertEquals(ID, meme.id)
        assertEquals(NAME, meme.name)
        assertEquals(BOTTOM_TEXT, meme.bottomText)
        assertEquals(IMAGE, meme.image)
        assertEquals(TAG, meme.tag)
        assertEquals(RANK, meme.rank)
        assertEquals(TOP_TEXT, meme.topText)
    }

    @Test
    fun `transform list of memes entity to realm list Test`() {
        assertEquals(ZERO_VALUE, MemeRealmMapper.transformRealmListOfMemes(emptyList()).size)
    }

}
