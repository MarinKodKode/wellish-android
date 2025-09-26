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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wellish.android.R

@Composable
fun TrySomethingNewSectionView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Section title
        SectionBarTitle(
            title = "Intenta algo nuevo",
            icon = "arrow.right"
        )

        // Main content card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 12.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            // Background image
            Image(
                painter = painterResource(id = R.drawable.backgroud_5_background), // Cambia por tu imagen
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

            // Content layout
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Top content with title, description and plus icon
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    // Left content - Title and description
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Outdoor Cycling",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White.copy(alpha = 0.8f)
                        )

                        Text(
                            text = "Be the king of the road, go beyond\nyour limits and enjoy the nature...",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.8f),
                            lineHeight = 20.sp
                        )
                    }

                    // Plus icon
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Add to favorites",
                        tint = Color.Red,
                        modifier = Modifier.size(22.dp)
                    )
                }

                // Bottom badges
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RedBadge(
                        text = "4.9",
                        icon = Icons.Default.Star
                    )

                    RedBadge(
                        text = "Beginner"
                    )
                }
            }
        }
    }
}

@Composable
fun RedBadge(
    text: String,
    icon: ImageVector? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Red.copy(alpha = 0.5f),
                        Color.Red.copy(alpha = 0.7f),
                        Color.Red
                    ),
                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                    end = androidx.compose.ui.geometry.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp), // Ajustado el padding vertical
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        icon?.let {
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = it,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(14.dp)
            )
        }
    }
}

// Alternativa con AsyncImage para URLs
@Composable
fun TrySomethingNewSectionViewWithUrl(
    imageUrl: String = "",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SectionBarTitle(
            title = "Intenta algo nuevo",
            icon = "arrow.right"
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 12.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            coil.compose.AsyncImage(
                model = imageUrl.ifEmpty { "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?ixlib=rb-4.0.3&auto=format&fit=crop&w=1000&q=80" },
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
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Outdoor Cycling",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White.copy(alpha = 0.8f)
                        )

                        Text(
                            text = "Be the king of the road, go beyond\nyour limits and enjoy the nature...",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.8f),
                            lineHeight = 20.sp
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Add to favorites",
                        tint = Color.Red,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RedBadge(
                        text = "4.9",
                        icon = Icons.Default.Star
                    )

                    RedBadge(
                        text = "Beginner"
                    )
                }
            }
        }
    }
}

// Variante personalizable del componente principal
@Composable
fun TrySomethingNewSectionViewCustom(
    title: String = "Outdoor Cycling",
    description: String = "Be the king of the road, go beyond\nyour limits and enjoy the nature...",
    rating: String = "4.9",
    difficulty: String = "Beginner",
    imageRes: Int? = null,
    imageUrl: String? = null,
    onAddClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SectionBarTitle(
            title = "Intenta algo nuevo",
            icon = "arrow.right"
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 12.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            // Conditional image loading
            when {
                imageRes != null -> {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                imageUrl != null -> {
                    coil.compose.AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.8f))
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = title,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White.copy(alpha = 0.8f)
                        )

                        Text(
                            text = description,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.8f),
                            lineHeight = 20.sp
                        )
                    }

                    IconButton(
                        onClick = onAddClick,
                        modifier = Modifier.size(22.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Add to favorites",
                            tint = Color.Red,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RedBadge(
                        text = rating,
                        icon = Icons.Default.Star
                    )

                    RedBadge(
                        text = difficulty
                    )
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
private fun TrySomethingNewSectionViewPreview() {
    TrySomethingNewSectionView()
}

@Preview(showBackground = true)
@Composable
private fun RedBadgePreview() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        RedBadge(text = "4.9", icon = Icons.Default.Star)
        RedBadge(text = "Beginner")
    }
}