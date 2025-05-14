package com.example.superhero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superhero.ui.theme.SuperHeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SuperHeroApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun SuperHeroPreview() {
    SuperHeroTheme(darkTheme = false) {
        SuperHeroApp()
    }
}

@Preview
@Composable
fun SuperHeroDarkThemePreview() {
    SuperHeroTheme(darkTheme = true) {
        SuperHeroApp()
    }
}

