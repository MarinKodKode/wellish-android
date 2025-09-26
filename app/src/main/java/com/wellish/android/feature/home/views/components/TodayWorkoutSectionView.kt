package com.wellish.android.feature.home.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wellish.android.R

@Composable
fun TodayWorkoutView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        // Section title bar
        SectionBarTitle(
            title = "La rutina de hoy 🔥",
            icon = "arrow.right"
        )

        // Workout card with background image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(horizontal = 12.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            // Background image
            Image(
                painter = painterResource(id = R.drawable.backgroud_5_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Dark overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )

            // Content over the image
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Upper Body\nWorkout",
                    fontSize = 40.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 45.sp
                )

                RoutineStatisticsRowView(
                    size = 14,
                    gap = 24
                )
            }
        }
    }
}

@Composable
fun SectionBarTitle(
    title: String,
    icon: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        when (icon) {
            "arrow.right" -> Text(
                text = "→",
                fontSize = 20.sp,
                color = Color.White
            )
            else -> Text(
                text = "→",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun RoutineStatisticsRowView(
    size: Int,
    gap: Int,
    modifier: Modifier = Modifier
) {
    // Placeholder para las estadísticas - implementa según tus necesidades
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(gap.dp)
    ) {
        // Ejemplo de estadísticas (personaliza según tu diseño original)
        StatisticItem(
            value = "45",
            label = "min",
            textSize = size
        )

        StatisticItem(
            value = "12",
            label = "ejercicios",
            textSize = size
        )

        StatisticItem(
            value = "350",
            label = "kcal",
            textSize = size
        )
    }
}

@Composable
private fun StatisticItem(
    value: String,
    label: String,
    textSize: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontSize = textSize.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = label,
            fontSize = (textSize - 2).sp,
            color = Color.White.copy(alpha = 0.8f)
        )
    }
}

// Alternativa usando AsyncImage si tienes URL de imagen
@Composable
fun TodayWorkoutViewWithUrl(
    imageUrl: String = "",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        SectionBarTitle(
            title = "La rutina de hoy 🔥",
            icon = "arrow.right"
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(horizontal = 12.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            // Background image usando AsyncImage (Coil)
            coil.compose.AsyncImage(
                model = imageUrl.ifEmpty { "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?ixlib=rb-4.0.3&auto=format&fit=crop&w=1000&q=80" },
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Upper Body\nWorkout",
                    fontSize = 40.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 45.sp
                )

                RoutineStatisticsRowView(size = 14, gap = 24)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TodayWorkoutViewPreview() {
    TodayWorkoutView()
}