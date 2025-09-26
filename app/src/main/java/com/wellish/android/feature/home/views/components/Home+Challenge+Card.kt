package com.wellish.android.feature.home.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.wellish.android.feature.home.models.ChallengeCardModel
import com.wellish.android.feature.home.models.SampleChallengeData
import java.util.*

@Composable
fun HomeChallengeCard(
    challenge: List<ChallengeCardModel>,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit = {},
    onArrowClick: () -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val cardWidth = screenWidth * 0.95f

    var imageLoadFailed by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .width(cardWidth)
            .height(180.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { onCardClick() }
    ) {
        // Fused background with gradient and image
        FusedBackgroundView(
            challenge = challenge[0],
            imageLoadFailed = imageLoadFailed,
            onImageLoadFailed = { imageLoadFailed = true }
        )

        // Decorative circles
        DecorativeCircles()

        // Main content
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .zIndex(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Header with icon and subtitle
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Using Material Icons based on icon string
                    when (challenge[0].icon) {
                        "directions_walk" -> Icon(
                            imageVector = Icons.Default.DirectionsWalk,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        "local_drink" -> Icon(
                            imageVector = Icons.Default.LocalDrink,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        "self_improvement" -> Icon(
                            imageVector = Icons.Default.SelfImprovement,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        "fitness_center" -> Icon(
                            imageVector = Icons.Default.FitnessCenter,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        "bedtime" -> Icon(
                            imageVector = Icons.Default.Bedtime,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        else -> Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Text(
                        text = "challenge.subtitle",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }

                // Title
                Text(
                    text = "challenge.title",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                // Main number and progress section
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Main number with unit
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "challenge.mainNumber",
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                        Text(
                            text = "challenge.unit",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White.copy(alpha = 0.9f),
                            modifier = Modifier.padding(bottom = 6.dp)
                        )
                    }

                    // Progress bar and text
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(120.dp)
                                .height(6.dp)
                        ) {
                            // Background bar
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Color.White.copy(alpha = 0.2f),
                                        RoundedCornerShape(6.dp)
                                    )
                            )

                            // Progress bar
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(120.dp * challenge[0].progress.toFloat())
                                    .background(
                                        Color.White,
                                        RoundedCornerShape(6.dp)
                                    )
                            )
                        }

                        Text(
                            text = challenge[0].progressText,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }

            // Arrow button
            IconButton(
                onClick = onArrowClick,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Ver más",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
private fun FusedBackgroundView(
    challenge: ChallengeCardModel,
    imageLoadFailed: Boolean,
    onImageLoadFailed: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Base gradient background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = challenge.colors,
                        start = androidx.compose.ui.geometry.Offset(0f, 0f),
                        end = androidx.compose.ui.geometry.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
        )

        // Image with fusion effect
        if (challenge.imageUrl?.isNotEmpty() == true && !imageLoadFailed) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.75f) // 75% width for better blending
                ) {
                    AsyncImage(
                        model = challenge.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .alpha(0.7f),
                        onState = { state ->
                            if (state is AsyncImagePainter.State.Error) {
                                onImageLoadFailed()
                            }
                        }
                    )

                    // Overlay with dark opacity
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.6f))
                    )

                    // Gradient mask for fusion effect
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.horizontalGradient(
                                    colorStops = arrayOf(
                                        0.0f to Color.Transparent,
                                        0.15f to Color.Black.copy(alpha = 0.1f),
                                        0.35f to Color.Black.copy(alpha = 0.4f),
                                        0.55f to Color.Black.copy(alpha = 0.8f),
                                        0.75f to Color.Black,
                                        1.0f to Color.Black
                                    )
                                )
                            )
                    )
                }
            }
        }
    }
}

@Composable
private fun DecorativeCircles() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Top right circle
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = 20.dp, y = (-20).dp)
                .size(60.dp)
                .background(
                    Color.White.copy(alpha = 0.1f),
                    CircleShape
                )
        )

        // Bottom left circle
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x = (-10).dp, y = 15.dp)
                .size(40.dp)
                .background(
                    Color.White.copy(alpha = 0.08f),
                    CircleShape
                )
        )
    }
}

// Preview con datos de ejemplo
@Preview(showBackground = true)
@Composable
private fun HomeChallengeCardPreview() {
    HomeChallengeCard(challenge = SampleChallengeData.getSampleChallenges())
}