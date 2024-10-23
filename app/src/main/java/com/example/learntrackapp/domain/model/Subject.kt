package com.example.learntrackapp.domain.model

import com.example.learntrackapp.ui.theme.gradient1
import com.example.learntrackapp.ui.theme.gradient2
import com.example.learntrackapp.ui.theme.gradient3
import com.example.learntrackapp.ui.theme.gradient4
import com.example.learntrackapp.ui.theme.gradient5

data class Subject(

    val name: String,
    val goalHours: String,
    val colors: List<androidx.compose.ui.graphics.Color>

){
    companion object {
        val subjectCardColor = listOf(gradient1, gradient2, gradient3, gradient4, gradient5)
    }
}
