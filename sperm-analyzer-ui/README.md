# Sperm Analyzer AI - Android UI

A modern, responsive, and bilingual (Arabic + English) Android application UI for AI-powered sperm analysis. This project provides a complete user interface design for medical professionals to analyze sperm samples using artificial intelligence.

## 🎨 Features

### Core Functionality
- **File Upload & Camera Capture**: Drag & drop interface with support for videos and images
- **Real-time Analysis Progress**: Animated progress indicators with time estimation
- **Detailed Results Display**: Comprehensive analysis results with visual overlays
- **Export Options**: PDF and CSV export capabilities
- **Settings Management**: Language switching, theme toggle, and backend configuration

### Design & User Experience
- **Medical-Grade Aesthetic**: Professional design suitable for clinical environments
- **Bilingual Support**: Full Arabic and English localization with RTL support
- **Material Design 3**: Modern UI components following Google's latest design system
- **Responsive Layout**: Optimized for Android phones (360x800 target resolution)
- **Dark Theme**: Medical professional-friendly dark interface

### Technical Features
- **Jetpack Compose**: Modern Android UI framework
- **Navigation Component**: Seamless screen transitions
- **Mock Data Integration**: Ready for backend API integration
- **File Management**: Comprehensive file handling and preview
- **Animation System**: Smooth transitions and visual feedback

## 🏗️ Project Structure

```
app/
├── src/main/
│   ├── java/com/koyb/spermanalyzer/
│   │   ├── MainActivity.kt                 # Main entry point
│   │   ├── data/
│   │   │   └── Models.kt                   # Data models and mock data
│   │   ├── ui/
│   │   │   ├── screens/
│   │   │   │   ├── MainScreen.kt          # File upload and capture
│   │   │   │   ├── AnalysisScreen.kt      # Progress tracking
│   │   │   │   ├── ResultsScreen.kt       # Analysis results
│   │   │   │   └── SettingsScreen.kt      # App configuration
│   │   │   └── theme/
│   │   │       ├── Color.kt               # Color definitions
│   │   │       ├── Type.kt                # Typography setup
│   │   │       └── Theme.kt               # Material Design theme
│   │   └── utils/
│   │       └── LanguageUtils.kt           # Language management
│   └── res/
│       ├── values/
│       │   ├── strings.xml                # English strings
│       │   ├── colors.xml                 # Color resources
│       │   └── themes.xml                 # App themes
│       ├── values-ar/
│       │   └── strings.xml                # Arabic strings
│       └── xml/
│           └── file_paths.xml             # File provider paths
```

## 🎯 Screens Overview

### 1. Main Screen
- Welcome section with app branding
- Drag & drop file upload area
- Upload and camera capture buttons
- File preview with metadata
- Start analysis floating action button

### 2. Analysis Progress Screen
- Media preview with AI overlay
- Animated bounding boxes showing detection
- Progress bar with time estimation
- Current processing step indicator
- Cancel analysis option

### 3. Results Screen
- Analyzed media with final bounding boxes
- Detailed metrics display:
  - Total sperm count
  - Motility score with grading
  - Density measurements
- Export options (PDF/CSV)
- Return to home functionality

### 4. Settings Screen
- Language selection (Arabic/English)
- Theme toggle (Dark/Light)
- Backend URL configuration
- Analysis log settings
- App information

## 🌍 Bilingual Support

The app provides complete bilingual support with:

- **Automatic RTL Layout**: Proper right-to-left layout for Arabic
- **Font Support**: Cairo font family for Arabic, Roboto for English
- **Cultural Adaptation**: Appropriate text sizing and spacing
- **Dynamic Language Switching**: Runtime language changes without restart

## 🎨 Design System

### Color Palette
- **Primary Background**: `#0D1B2A` (Deep Navy Blue)
- **Secondary Surface**: `#1B263B`
- **Accent**: `#00B4D8` (Cyan Blue)
- **Text Primary**: `#FFFFFF`
- **Text Secondary**: `#B0BEC5`

### Typography
- **Arabic**: Cairo font family with proper Arabic text handling
- **English**: Roboto font family following Material Design guidelines
- **Responsive Sizing**: Headlines (20sp+), body text (14-16sp), labels (12sp)

### Components
- Material Design 3 components throughout
- Custom medical-grade styling
- Consistent spacing and elevation
- Smooth animations and transitions

## 🔧 Backend Integration Ready

The UI is designed to integrate seamlessly with the Koyb.com backend:

- **Configurable Backend URL**: Settings screen allows API endpoint configuration
- **Mock Data Structure**: All data models mirror expected API responses
- **File Upload Ready**: File handling prepared for multipart uploads
- **Progress Tracking**: Real-time progress updates from backend analysis
- **Result Processing**: Structured display of analysis results

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 23+ (API level 23)
- Kotlin 1.8+

### Installation
1. Clone or download the project
2. Open in Android Studio
3. Sync Gradle dependencies
4. Run on device or emulator

### Dependencies
```kotlin
// Core Android
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
implementation("androidx.activity:activity-compose:1.8.2")

// Compose
implementation(platform("androidx.compose:compose-bom:2024.02.00"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.compose.material:material-icons-extended")

// Navigation
implementation("androidx.navigation:navigation-compose:2.7.6")
```

## 🎯 Usage

1. **File Selection**: Use upload button or drag & drop to select video/image files
2. **Analysis**: Start analysis to see animated progress with AI detection overlay
3. **Results**: View comprehensive analysis results with visual overlays
4. **Export**: Export results as PDF or CSV files
5. **Settings**: Customize language, theme, and backend configuration

## 🔮 Future Enhancements

- **Real Backend Integration**: Connect to actual Koyb.com API
- **Camera Permissions**: Implement actual camera capture functionality
- **File Validation**: Add comprehensive file format validation
- **Offline Mode**: Local analysis capabilities
- **Enhanced Export**: More export formats and customization options

## 🏥 Medical Grade Design

This UI is specifically designed for medical and laboratory environments:

- **Professional Aesthetics**: Clean, clinical design language
- **High Contrast**: Optimized for various lighting conditions
- **Error Prevention**: Clear visual feedback and confirmation dialogs
- **Accessibility**: Large touch targets and readable text
- **Data Privacy**: Local storage options and secure backend communication

## 📱 Device Support

- **Target Resolution**: 360x800 (standard Android phone)
- **Minimum SDK**: API 23 (Android 6.0)
- **Target SDK**: API 34 (Android 14)
- **Orientation**: Portrait mode optimized
- **Screen Sizes**: Responsive design for various phone sizes

## 🤝 Contributing

This is a UI design project. For backend integration or additional features, please coordinate with the Koyb.com development team.

## 📄 License

This project is designed for Koyb Medical Solutions. All rights reserved.

---

**Built with ❤️ using Jetpack Compose and Material Design 3**