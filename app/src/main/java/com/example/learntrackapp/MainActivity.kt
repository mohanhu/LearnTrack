package com.example.learntrackapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learntrackapp.presentation.dashboard.DashBoardScreen
import com.example.learntrackapp.ui.theme.LearnTrackAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTrackAppTheme {
                DashBoardScreen()
            }
        }
    }
}

