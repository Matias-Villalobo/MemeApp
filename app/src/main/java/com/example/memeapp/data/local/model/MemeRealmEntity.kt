package com.example.memeapp.data.local.model

import com.example.memeapp.data.local.model.utils.ConstantsUtils.EMPTY_STRING
import com.example.memeapp.data.local.model.utils.ConstantsUtils.VALUE_ZERO
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MemeRealmEntity(
    @PrimaryKey
    var id: Int = VALUE_ZERO,
    var bottomText: String = EMPTY_STRING,
    var image: String = EMPTY_STRING,
    var name: String = EMPTY_STRING,
    var tag: String = EMPTY_STRING,
    var rank: Int = VALUE_ZERO,
    var topText: String = EMPTY_STRING
) : RealmObject()
