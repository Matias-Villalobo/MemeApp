package com.example.memeapp.domain.entity

data class MemesEntity(
    val id: Int,
    val bottomText: String,
    val image: String,
    val name: String,
    val tag: Int,
    val rank: String,
    val topText: String
)
