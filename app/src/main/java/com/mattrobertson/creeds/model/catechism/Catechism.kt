package com.mattrobertson.creeds.model.catechism

data class Catechism(
    val title: String,
    val questions: List<QuestionAndAnswer>
) {
    val numQuestions: Int
        get() = questions.size
}