package com.example.learntrackapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.learntrackapp.R

@Composable
fun SubjectCard (
    modifier: Modifier = Modifier,
    subjectName:String,
    gradient: List<Color>,
    onClick:()->Unit
) {

    Box(modifier = modifier.size(150.dp).clickable {
        onClick.invoke()
    }.background(
        brush = Brush.verticalGradient(gradient),
        shape = MaterialTheme.shapes.medium
    )) {
        Column (
            modifier = Modifier.fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(painter = painterResource(id = R.drawable.st1), contentDescription = "",
                modifier = Modifier.size(80.dp))

            Text(text = subjectName, style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Center,
                color = Color.White)
        }

    }

}