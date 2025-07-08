package com.koyb.spermanalyzer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.koyb.spermanalyzer.R
import com.koyb.spermanalyzer.data.AppSettings
import com.koyb.spermanalyzer.ui.theme.LocalLanguage
import com.koyb.spermanalyzer.ui.theme.SpermAnalyzerTheme
import com.koyb.spermanalyzer.utils.LanguageConstants
import com.koyb.spermanalyzer.utils.rememberLanguageManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit = {}
) {
    var settings by remember {
        mutableStateOf(
            AppSettings(
                language = LocalLanguage.current,
                isDarkMode = true,
                backendUrl = "https://api.koyb.com",
                saveLogs = true
            )
        )
    }
    
    val languageManager = rememberLanguageManager()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.settings),
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Language Settings
            SettingsSection(
                title = stringResource(R.string.language_setting),
                icon = Icons.Default.Language
            ) {
                LanguageDropdown(
                    currentLanguage = settings.language,
                    onLanguageChange = { newLanguage ->
                        settings = settings.copy(language = newLanguage)
                        languageManager.setLanguage(newLanguage)
                    }
                )
            }
            
            // Theme Settings
            SettingsSection(
                title = stringResource(R.string.theme_setting),
                icon = Icons.Default.DarkMode
            ) {
                SettingsToggle(
                    title = stringResource(R.string.dark_mode),
                    subtitle = if (settings.isDarkMode) "Enabled" else "Disabled",
                    checked = settings.isDarkMode,
                    onCheckedChange = { settings = settings.copy(isDarkMode = it) }
                )
            }
            
            // Backend Configuration
            SettingsSection(
                title = "Backend Configuration",
                icon = Icons.Default.Save
            ) {
                BackendUrlField(
                    url = settings.backendUrl,
                    onUrlChange = { settings = settings.copy(backendUrl = it) }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                SettingsToggle(
                    title = stringResource(R.string.save_logs),
                    subtitle = stringResource(R.string.save_logs_subtitle),
                    checked = settings.saveLogs,
                    onCheckedChange = { settings = settings.copy(saveLogs = it) }
                )
            }
            
            // About Section
            SettingsSection(
                title = stringResource(R.string.about_app),
                icon = Icons.Default.Info
            ) {
                AboutSection()
            }
        }
    }
}

@Composable
private fun SettingsSection(
    title: String,
    icon: ImageVector,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LanguageDropdown(
    currentLanguage: String,
    onLanguageChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val languages = LanguageConstants.supportedLanguages
    val selectedLanguage = languages.find { it.code == currentLanguage }
        ?: languages.first()
    
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            value = selectedLanguage.displayName,
            onValueChange = {},
            readOnly = true,
            label = { Text(stringResource(R.string.language_setting)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Translate,
                    contentDescription = null
                )
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            shape = RoundedCornerShape(12.dp)
        )
        
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            languages.forEach { language ->
                DropdownMenuItem(
                    text = { Text(language.displayName) },
                    onClick = {
                        onLanguageChange(language.code)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun SettingsToggle(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
private fun BackendUrlField(
    url: String,
    onUrlChange: (String) -> Unit
) {
    OutlinedTextField(
        value = url,
        onValueChange = onUrlChange,
        label = { Text(stringResource(R.string.backend_url)) },
        placeholder = { Text(stringResource(R.string.backend_url_hint)) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        singleLine = true
    )
}

@Composable
private fun AboutSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        InfoRow(
            label = stringResource(R.string.app_name),
            value = "Sperm Analyzer AI"
        )
        InfoRow(
            label = stringResource(R.string.version),
            value = "1.0.0"
        )
        InfoRow(
            label = "Developer",
            value = "Koyb Medical Solutions"
        )
        InfoRow(
            label = "Backend API",
            value = "api.koyb.com"
        )
    }
}

@Composable
private fun InfoRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium
            ),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SpermAnalyzerTheme {
        SettingsScreen()
    }
}

@Preview(showBackground = true, locale = "ar")
@Composable
fun SettingsScreenArabicPreview() {
    SpermAnalyzerTheme(language = "ar") {
        SettingsScreen()
    }
}