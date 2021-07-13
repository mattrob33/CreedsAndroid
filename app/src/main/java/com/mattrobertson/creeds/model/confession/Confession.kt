package com.mattrobertson.creeds.model.confession

data class Confession(
    val title: String,
    val year: Int,
    val chapters: List<Chapter>
)