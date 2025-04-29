package com.example.compose4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Four_composable(
                        titleText = "Text composable\n",
                        contextText = "Displays text and follows the recommended Material Design guidelines.\n",
                        titleImage = "Image composable",
                        contextImage = "Creates a composable that lays out and draws a given Painter class object.\n",
                        titleRow = "Row composable\n",
                        contextRow = "A layout composable that places its children in a horizontal sequence.\n",
                        titleColumn = "Column composable\n",
                        contextColumn = "A layout composable that places its children in a vertical sequence.\n"
                    )
                }
            }
        }
    }
}


@Composable
fun Four_composable(
    titleText: String, titleImage: String,
    titleRow: String, titleColumn: String,
    contextText: String, contextImage: String,
    contextRow: String, contextColumn: String,
    modifier: Modifier = Modifier
    ){
    Column (
        modifier = modifier
            .fillMaxSize()
    ) {
        Row (
            modifier = modifier
                .weight(2f)
        ) {
            Text_composable(
                titleText = titleText,
                contextText = contextText,
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFEADDFF))
            )
            Image_composable(
                titleImage = titleImage,
                contextImage = contextImage,
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFD0BCFF))
            )
        }
        Row (
            modifier = modifier
                .weight(2f)
        ) {
            Row_composable(
                titleRow = titleRow,
                contextRow = contextRow,
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFB69DF8))
            )
            Column_composable(
                titleColumn = titleColumn,
                contextColumn = contextColumn,
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFF6EDFF))
            )
        }
    }
}

@Composable
fun Text_composable(titleText: String, contextText: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = titleText,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Text(
            text = contextText,
            textAlign = TextAlign.Justify,
            modifier = modifier
        )
    }
}

@Composable
fun Image_composable(titleImage: String, contextImage: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = titleImage,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Text(
            text = contextImage,
            textAlign = TextAlign.Justify,
            modifier = modifier
        )
    }
}

@Composable
fun Row_composable(titleRow: String, contextRow: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = titleRow,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Text(
            text = contextRow,
            textAlign = TextAlign.Justify,
            modifier = modifier
        )
    }
}

@Composable
fun Column_composable(titleColumn: String, contextColumn: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = titleColumn,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Text(
            text = contextColumn,
            textAlign = TextAlign.Justify,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose4Theme {
        Four_composable(
            titleText = "Text composable\n",
            contextText = "Displays text and follows the recommended Material Design guidelines.\n",
            titleImage = "Image composable",
            contextImage = "Creates a composable that lays out and draws a given Painter class object.\n",
            titleRow = "Row composable\n",
            contextRow = "A layout composable that places its children in a horizontal sequence.\n",
            titleColumn = "Column composable\n",
            contextColumn = "A layout composable that places its children in a vertical sequence.\n"
        )
    }
}