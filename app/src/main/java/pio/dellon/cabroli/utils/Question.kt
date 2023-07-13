package pio.dellon.cabroli.utils

data class Question(
    val id: Int,
    val question: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val correctAnswer: Int
)