package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //import androidx.compose.material3.MaterialTheme
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskImage(
                        context = "All tasks completed",
                        context2 = "Nice work!"
                    )
                }
            }
        }
    }
}


@Composable
fun TaskImage(context2: String, context: String) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column (
        // horizontal 수평 가운데 정렬, vertical 수직 가운데 정렬
        // 아래 명령은 컬럼 내부의 요소에 대해서 적용됨
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
        )
        TaskText(
            context = context,
            context2 = context2
        )

    }

}

@Composable
fun TaskText(context: String, context2: String, modifier: Modifier = Modifier){

    Column(
        // horizontal 수평 가운데 정렬, vertical 수직 가운데 정렬
        // 아래 명령은 컬럼 내부의 요소에 대해서 적용됨
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = context,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = context2,
            fontSize = 16.sp,
            modifier = modifier
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskImage(
            context = "All tasks completed",
            context2 = "Nice work!"
        )
    }
}