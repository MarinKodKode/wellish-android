package com.wellish.android.feature.home.views.subviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoriesSectionView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Section title bar
        SectionBarTitle(
            title = "Categorias",
            icon = "arrow.right"
        )

        // Horizontal scrollable categories
        LazyRow(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(getSampleCategories()) { category ->
                CategorieCard(category = category)
            }
        }
    }
}

@Composable
fun CategorieCard(
    category: CategoryModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .size(160.dp)
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = category.gradient,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Title section
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = category.title,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        lineHeight = 32.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                // Bottom section with rating and icon
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    // Rating and routines info
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        // Rating row
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = category.rating,
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            )
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                        }

                        // Routines count
                        Text(
                            text = category.routinesCount,
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }

                    // Category icon
                    Icon(
                        imageVector = category.icon,
                        contentDescription = category.title,
                        tint = Color.White,
                        modifier = Modifier.size(52.dp)
                    )
                }
            }
        }
    }
}

// Data model for categories
data class CategoryModel(
    val id: String,
    val title: String,
    val rating: String,
    val routinesCount: String,
    val icon: ImageVector,
    val gradient: Brush
)

// Sample categories data
fun getSampleCategories(): List<CategoryModel> {
    return listOf(
        CategoryModel(
            id = "1",
            title = "Home\nWorkout",
            rating = "4.9",
            routinesCount = "12 routines",
            icon = Icons.Default.Home,
            gradient = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF667eea),
                    Color(0xFF764ba2)
                )
            )
        ),
        CategoryModel(
            id = "2",
            title = "Cardio\nTraining",
            rating = "4.8",
            routinesCount = "18 routines",
            icon = Icons.Default.DirectionsRun,
            gradient = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFf093fb),
                    Color(0xFFf5576c)
                )
            )
        ),
        CategoryModel(
            id = "3",
            title = "Strength\nTraining",
            rating = "4.7",
            routinesCount = "15 routines",
            icon = Icons.Default.FitnessCenter,
            gradient = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF4facfe),
                    Color(0xFF00f2fe)
                )
            )
        ),
        CategoryModel(
            id = "4",
            title = "Yoga &\nMeditation",
            rating = "4.9",
            routinesCount = "22 routines",
            icon = Icons.Default.SelfImprovement,
            gradient = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF43e97b),
                    Color(0xFF38f9d7)
                )
            )
        ),
        CategoryModel(
            id = "5",
            title = "Outdoor\nRunning",
            rating = "4.6",
            routinesCount = "8 routines",
            icon = Icons.Default.Terrain,
            gradient = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFfa709a),
                    Color(0xFFfee140)
                )
            )
        )
    )
}

// Reuse SectionBarTitle from previous component or create if needed
@Composable
private fun SectionBarTitle(
    title: String,
    icon: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
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
private fun CategoriesSectionViewPreview() {
    CategoriesSectionView()
}

@Preview(showBackground = true)
@Composable
private fun CategorieCardPreview() {
    CategorieCard(category = getSampleCategories()[0])
}