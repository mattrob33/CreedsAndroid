package com.mattrobertson.creeds.model.confession

data class Confession(
    val title: String,
    val abbreviation: String,
    val year: Int,
    val chapters: List<Chapter>,
    val hasSingleSectionChapters: Boolean = false
) {
    val chapterCount: Int by lazy {
        chapters.size
    }
}