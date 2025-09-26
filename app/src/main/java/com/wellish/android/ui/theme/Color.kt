package com.wellish.android.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.Color

object FitnessColors {

    // MARK: - Primary Colors
    val PrimaryFitnessBlue = Color(0xFF0F172A)        // Replace with your actual hex value
    val FitnessSuccess = Color(0xFF10B981)            // Replace with your actual hex value
    val EnergyFitnessOrange = Color(0xFFFBBF24)       // Replace with your actual hex value
    val ErrorFitnessRed = Color(0xFFEF4444)           // Replace with your actual hex value
    val PremiumFitnessPurple = Color(0xFFAF52DE)      // Replace with your actual hex value
    val InfoFitnessCyan = Color(0xFF5AC8FA)           // Replace with your actual hex value

    // MARK: - Text Colors
    val FitnessTextPrimary = Color(0xFF1C1C1E)        // Replace with your actual hex value
    val FitnessTextSecondary = Color(0xFF8E8E93)      // Replace with your actual hex value

    // MARK: - Background Colors
    val FitnessBackgroundPrimary = Color(0xFFFFFFFF)   // Replace with your actual hex value
    val FitnessBackgroundSecondary = Color(0xFFF2F2F7) // Replace with your actual hex value

    // MARK: - Semantic Colors (Aliases)
    val FitnessProgress = FitnessSuccess
    val FitnessWarning = EnergyFitnessOrange
    val FitnessError = ErrorFitnessRed
    val FitnessPrimary = PrimaryFitnessBlue
    val FitnessInfo = InfoFitnessCyan
    val FitnessPremium = PremiumFitnessPurple
}

// Extension for easy access in Composables
@get:Composable
val Colors.primaryFitnessBlue: Color
    get() = FitnessColors.PrimaryFitnessBlue

@get:Composable
val Colors.fitnessSuccess: Color
    get() = FitnessColors.FitnessSuccess

@get:Composable
val Colors.energyFitnessOrange: Color
    get() = FitnessColors.EnergyFitnessOrange

@get:Composable
val Colors.errorFitnessRed: Color
    get() = FitnessColors.ErrorFitnessRed

@get:Composable
val Colors.premiumFitnessPurple: Color
    get() = FitnessColors.PremiumFitnessPurple

@get:Composable
val Colors.infoFitnessCyan: Color
    get() = FitnessColors.InfoFitnessCyan

@get:Composable
val Colors.fitnessTextPrimary: Color
    get() = FitnessColors.FitnessTextPrimary

@get:Composable
val Colors.fitnessTextSecondary: Color
    get() = FitnessColors.FitnessTextSecondary

@get:Composable
val Colors.fitnessBackgroundPrimary: Color
    get() = FitnessColors.FitnessBackgroundPrimary

@get:Composable
val Colors.fitnessBackgroundSecondary: Color
    get() = FitnessColors.FitnessBackgroundSecondary

@get:Composable
val Colors.fitnessProgress: Color
    get() = FitnessColors.FitnessProgress

@get:Composable
val Colors.fitnessWarning: Color
    get() = FitnessColors.FitnessWarning

@get:Composable
val Colors.fitnessError: Color
    get() = FitnessColors.FitnessError

@get:Composable
val Colors.fitnessPrimary: Color
    get() = FitnessColors.FitnessPrimary

@get:Composable
val Colors.fitnessInfo: Color
    get() = FitnessColors.FitnessInfo

@get:Composable
val Colors.fitnessPremium: Color
    get() = FitnessColors.FitnessPremium