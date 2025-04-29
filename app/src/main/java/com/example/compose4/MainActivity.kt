package com.example.compose4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose4.ui.theme.Compose4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose4Theme {
                // import androidx.compose.material3.Surface
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //import androidx.compose.material3.MaterialTheme
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text_composable(
                        title = "Text composable\n",
                        context = "Displays text and follows the recommended Material Design guidelines.\n"
                    )
                }
            }
        }
    }
}

@Composable
fun Text_composable(title: String, context: String, modifier: Modifier = Modifier) {
    Column(
        
    ) {
        Text(
            text = title,
            modifier = modifier
        )
        Text(
            text = context,
            textAlign = TextAlign.Justify,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose4Theme {
        Text_composable(
            title = "Text composable\n",
            context = "Displays text and follows the recommended Material Design guidelines.\n"
        )
    }
}