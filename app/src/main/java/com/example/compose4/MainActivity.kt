package com.example.compose4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
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
                    QuadrupleComposable()
                }
            }
        }
    }
}

@Composable
fun QuadrupleComposable(){
    Column(Modifier.fillMaxWidth()){
        Row(Modifier.weight(1f)){
            OneOfQuadruple(
                backgroundColor = Color(0xFFEADDFF),
                title = stringResource(R.string.text_composable),
                description = stringResource(R.string.displays_text_and_follows_the_recommended_material_design_guidelines),
                modifier = Modifier.weight(1f)
            )
            OneOfQuadruple(
                backgroundColor = Color(0xFFD0BCFF),
                title = stringResource(R.string.image_composable),
                description = stringResource(R.string.creates_a_composable_that_lays_out_and_draws_a_given_painter_class_object),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight((1f))){
            OneOfQuadruple(
                backgroundColor = Color(0xFFB69DF8),
                title = stringResource(R.string.row_composable),
                description = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_horizontal_sequence),
                modifier = Modifier.weight(1f)
            )
            OneOfQuadruple(
                backgroundColor = Color(0xFFF6EDFF),
                title = stringResource(R.string.column_composable),
                description = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_vertical_sequence),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun OneOfQuadruple(backgroundColor: Color, title: String, description: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose4Theme {
        QuadrupleComposable()
    }
}