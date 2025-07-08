package com.koyb.spermanalyzer.data

import android.net.Uri

data class AnalysisFile(
    val uri: Uri? = null,
    val fileName: String = "",
    val fileType: FileType = FileType.UNKNOWN,
    val fileSizeBytes: Long = 0
)

enum class FileType {
    VIDEO,
    IMAGE,
    UNKNOWN
}

data class AnalysisProgress(
    val progress: Float = 0f,
    val estimatedTimeSeconds: Int = 0,
    val currentStep: String = "",
    val isComplete: Boolean = false
)

data class AnalysisResult(
    val spermCount: Int,
    val motilityScore: Float,
    val density: Float,
    val motilityGrade: MotilityGrade,
    val densityGrade: DensityGrade,
    val analysisTimestamp: Long = System.currentTimeMillis(),
    val boundingBoxes: List<SpermBoundingBox> = emptyList()
)

data class SpermBoundingBox(
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float,
    val confidence: Float,
    val isMotile: Boolean
)

enum class MotilityGrade {
    EXCELLENT,
    GOOD,
    MODERATE,
    LOW
}

enum class DensityGrade {
    EXCELLENT,
    GOOD,
    MODERATE,
    LOW
}

data class AppSettings(
    val language: String = "en",
    val isDarkMode: Boolean = true,
    val backendUrl: String = "https://api.koyb.com",
    val saveLogs: Boolean = true
)

object MockData {
    val sampleAnalysisResult = AnalysisResult(
        spermCount = 45,
        motilityScore = 78.5f,
        density = 52.3f,
        motilityGrade = MotilityGrade.GOOD,
        densityGrade = DensityGrade.EXCELLENT,
        boundingBoxes = listOf(
            SpermBoundingBox(0.2f, 0.3f, 0.05f, 0.08f, 0.95f, true),
            SpermBoundingBox(0.5f, 0.1f, 0.06f, 0.09f, 0.88f, true),
            SpermBoundingBox(0.7f, 0.6f, 0.04f, 0.07f, 0.82f, false),
            SpermBoundingBox(0.1f, 0.8f, 0.05f, 0.08f, 0.91f, true),
            SpermBoundingBox(0.9f, 0.4f, 0.06f, 0.09f, 0.87f, false)
        )
    )
    
    fun createMockProgress(currentProgress: Float): AnalysisProgress {
        val steps = listOf(
            "Initializing AI model...",
            "Preprocessing image/video...",
            "Detecting sperm cells...",
            "Analyzing motility...",
            "Calculating results...",
            "Finalizing analysis..."
        )
        
        val stepIndex = (currentProgress * steps.size).toInt().coerceAtMost(steps.size - 1)
        val estimatedTime = ((1f - currentProgress) * 30).toInt()
        
        return AnalysisProgress(
            progress = currentProgress,
            estimatedTimeSeconds = estimatedTime,
            currentStep = steps[stepIndex],
            isComplete = currentProgress >= 1f
        )
    }
}