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

@Composable
fun MainHomeView(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // Tu código de Jetpack Compose aquí
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121212)) // Color de fondo temporal
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
                ChallengeSectionSubview(
                    challenges = getDummyChallenges() // Datos temporales
                )
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
                TrySomethingNewSectionView(
                    modifier = Modifier.padding(bottom = 30.dp)
                )
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

@Composable
fun TodayWorkoutView() {
    Text(
        text = "Entrenamiento de Hoy",
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun CategoriesSectionView() {
    Text(
        text = "Categorías",
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun PopularWorkoutSectionView() {
    Text(
        text = "Entrenamientos Populares",
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun TrySomethingNewSectionView(modifier: Modifier = Modifier) {
    Text(
        text = "Prueba Algo Nuevo",
        modifier = modifier.padding(16.dp)
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