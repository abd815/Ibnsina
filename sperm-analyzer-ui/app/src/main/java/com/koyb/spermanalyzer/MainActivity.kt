package com.koyb.spermanalyzer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.koyb.spermanalyzer.ui.screens.AnalysisScreen
import com.koyb.spermanalyzer.ui.screens.MainScreen
import com.koyb.spermanalyzer.ui.screens.ResultsScreen
import com.koyb.spermanalyzer.ui.screens.SettingsScreen
import com.koyb.spermanalyzer.ui.theme.SpermAnalyzerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpermAnalyzerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpermAnalyzerApp()
                }
            }
        }
    }
}

@Composable
fun SpermAnalyzerApp() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            MainScreen(
                onNavigateToAnalysis = { navController.navigate("analysis") },
                onNavigateToSettings = { navController.navigate("settings") }
            )
        }
        composable("analysis") {
            AnalysisScreen(
                onNavigateToResults = { navController.navigate("results") },
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable("results") {
            ResultsScreen(
                onNavigateToMain = { 
                    navController.popBackStack("main", inclusive = false)
                }
            )
        }
        composable("settings") {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpermAnalyzerAppPreview() {
    SpermAnalyzerTheme {
        SpermAnalyzerApp()
    }
}