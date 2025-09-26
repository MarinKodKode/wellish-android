package com.wellish.android.feature.home.views.subviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wellish.android.R
@Composable
fun PopularWorkoutSectionView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        SectionBarTitle(
            title = "Rutinas Populares 🏆",
            icon = "arrow.right"
        )

        // Popular workout card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(horizontal = 14.dp)
                .clip(RoundedCornerShape(16.dp))
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
                    .background(
                        Color.Black.copy(alpha = 0.8f) // Equivalente a fitnessBackgroundPrimary.opacity(0.8)
                    )
            )

            // Content over the image
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Workout title
                Text(
                    text = "Burning Chest\nWorkout",
                    fontSize = 28.sp,
                    fontFamily = FontFamily.Default, // Reemplaza con tu fuente "Lemon"
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary, // Equivalente a Color.primary
                    lineHeight = 32.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                // Bottom row with statistics and badge
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RoutineStatisticsRowView(
                        size = 14,
                        gap = 8,
                        numberOfStats = 2,
                        alignment = Alignment.Start
                    )

                    Badge(label = "Intermediate")
                }
            }
        }
    }
}

@Composable
fun RoutineStatisticsRowView(
    size: Int,
    gap: Int,
    numberOfStats: Int = 3,
    alignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = when (alignment) {
            Alignment.Start -> Arrangement.Start
            Alignment.End -> Arrangement.End
            else -> Arrangement.Center
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(gap.dp)
        ) {
            // Exercises stat
            StatisticItem(
                icon = Icons.Default.FitnessCenter, // Equivalente a "dumbbell"
                text = "8 exercises",
                iconSize = size,
                textSize = size
            )

            // Duration stat
            StatisticItem(
                icon = Icons.Default.AccessTime, // Equivalente a "clock"
                text = "90min",
                iconSize = size,
                textSize = size
            )

            // Calories stat (conditional)
            if (numberOfStats == 3) {
                StatisticItem(
                    icon = Icons.Default.LocalFireDepartment, // Equivalente a "flame"
                    text = "1,200kcal",
                    iconSize = size,
                    textSize = size
                )
            }
        }
    }
}

@Composable
private fun StatisticItem(
    icon: ImageVector,
    text: String,
    iconSize: Int,
    textSize: Int
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(iconSize.dp)
        )
        Text(
            text = text,
            fontSize = textSize.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Composable
fun Badge(
    label: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f)
        )
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

// Alternativa con AsyncImage para URLs
@Composable
fun PopularWorkoutSectionViewWithUrl(
    imageUrl: String = "",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        SectionBarTitle(
            title = "Rutinas Populares 🏆",
            icon = "arrow.right"
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(horizontal = 14.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            coil.compose.AsyncImage(
                model = imageUrl.ifEmpty { "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?ixlib=rb-4.0.3&auto=format&fit=crop&w=1000&q=80" },
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.8f))
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Burning Chest\nWorkout",
                    fontSize = 28.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    lineHeight = 32.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RoutineStatisticsRowView(
                        size = 14,
                        gap = 8,
                        numberOfStats = 2,
                        alignment = Alignment.Start
                    )

                    Badge(label = "Intermediate")
                }
            }
        }
    }
}

// Reuse SectionBarTitle from previous components
@Composable
private fun SectionBarTitle(
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
            color = MaterialTheme.colorScheme.onBackground
        )

        when (icon) {
            "arrow.right" -> Text(
                text = "→",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary
            )
            else -> Text(
                text = "→",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PopularWorkoutSectionViewPreview() {
    PopularWorkoutSectionView()
}

@Preview(showBackground = true)
@Composable
private fun RoutineStatisticsRowViewPreview() {
    RoutineStatisticsRowView(size = 14, gap = 24)
}

@Preview(showBackground = true)
@Composable
private fun BadgePreview() {
    Badge(label = "Intermediate")
}
