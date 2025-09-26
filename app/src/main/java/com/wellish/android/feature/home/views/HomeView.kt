package com.wellish.android.feature.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wellish.android.feature.home.models.SampleChallengeData
import com.wellish.android.feature.home.views.components.HomeChallengeCard
import com.wellish.android.feature.home.views.components.TodayWorkoutView
import com.wellish.android.feature.home.views.subviews.CategoriesSectionView
import com.wellish.android.feature.home.views.subviews.PopularWorkoutSectionView
import com.wellish.android.feature.home.views.subviews.TrySomethingNewSectionView

@Composable
fun MainHomeView(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // Tu código de Jetpack Compose aquí
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clipToBounds(),
            verticalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            item {
                HomeHeaderView()
            }

            item {
                HomeChallengeCard(SampleChallengeData.getSampleChallenges())
            }

            item {
                TodayWorkoutView()
            }

            item {
                CategoriesSectionView()
            }

            item {
                PopularWorkoutSectionView()
            }

            item {
                TrySomethingNewSectionView()
            }
        }
    }
}

// Composables temporales para que compile
@Composable
fun HomeHeaderView() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Header Temporal",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ChallengeSectionSubview(challenges: List<String>) {
    Text(
        text = "Sección de Desafíos",
        modifier = Modifier.padding(16.dp)
    )
}

// Datos temporales
fun getDummyChallenges(): List<String> {
    return listOf("Desafío 1", "Desafío 2", "Desafío 3")
}

@Preview(showBackground = true)
@Composable
private fun MainHomeViewPreview() {
    MainHomeView(
        navController = rememberNavController()
    )
}