package com.wellish.android.feature.home.models

import androidx.compose.ui.graphics.Color
import java.util.*

data class ChallengeCardModel(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val subtitle: String,
    val mainNumber: String,
    val unit: String,
    val progress: Double,
    val progressText: String,
    val buttonText: String,
    val colors: List<Color>,
    val imageUrl: String? = null,
    val icon: String
)


// Sample data for testing
object SampleChallengeData {
    fun getSampleChallenges(): List<ChallengeCardModel> {
        return listOf(
            ChallengeCardModel(
                title = "Daily Steps",
                subtitle = "Keep moving forward",
                mainNumber = "8,547",
                unit = "steps",
                progress = 0.85,
                progressText = "85% complete",
                buttonText = "View Progress",
                colors = listOf(Color(0xFF6B73FF), Color(0xFF9DD5FF)),
                imageUrl = null,
                icon = "directions_walk"
            ),
            ChallengeCardModel(
                title = "Water Intake",
                subtitle = "Stay hydrated",
                mainNumber = "6",
                unit = "glasses",
                progress = 0.75,
                progressText = "6 of 8 glasses",
                buttonText = "Log Water",
                colors = listOf(Color(0xFF4ECDC4), Color(0xFF44A08D)),
                imageUrl = null,
                icon = "local_drink"
            ),
            ChallengeCardModel(
                title = "Meditation",
                subtitle = "Find your inner peace",
                mainNumber = "15",
                unit = "minutes",
                progress = 1.0,
                progressText = "Goal achieved!",
                buttonText = "Start Session",
                colors = listOf(Color(0xFFFF6B6B), Color(0xFFFFE66D)),
                imageUrl = null,
                icon = "self_improvement"
            )
        )
    }
}