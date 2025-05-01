package com.example.basicstatepractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(
        count = count,
        modifier = modifier,
        onIncrement = { count++ },
        onReset = { count = 0 }
    )
}

@Composable
private fun StatelessCounter(count: Int, onIncrement: () -> Unit,onReset: () -> Unit, modifier: Modifier = Modifier ) {
    Column(modifier = modifier.padding(16.dp)) {
        if ( count > 0) {
            var showTask by rememberSaveable { mutableStateOf(true) }
            var showCheck by rememberSaveable { mutableStateOf(false) }
            if (showTask) {
                WellnessTaskItem(
                    onClose = { showTask = false },
                    taskName = "Have you taken your 15 minute walk today?",
                    checked = showCheck,
                    onCheckedChange = {checked -> showCheck = checked}
                )
            }
            Text(
                text = "You've had $count glasses."
            )
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = onIncrement, enabled = count < 10) {
                Text("Add one")
            }
            Button(
                onClick = onReset,
                Modifier.padding(start = 8.dp)
            ) {
                Text("Clear water count")
            }
        }

    }
}
