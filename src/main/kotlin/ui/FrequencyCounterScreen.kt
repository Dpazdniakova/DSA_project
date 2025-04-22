package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import utils.mostFrequentElement


@Composable
fun FrequencyCounterScreen() {

    var userInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }
    var error by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter strings separated by commas:")

        TextField(
            value = userInput,
            onValueChange = {
                userInput = it
                result = null
                error = null
            },
            placeholder = { Text("e.g. Apple,Yogurt,Apple") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Button(onClick = {

                val cleanedList = userInput
                    .split(",")
                    .map { it.trim() }
                    .filter { it.isNotBlank() }

                if (cleanedList.isEmpty()) {
                    error = "Please enter at least one valid string."
                    result = null
                }

                else {
                    val mostFrequent = mostFrequentElement(cleanedList)
                    result = mostFrequent
                    error = null
                }
        }) {
            Text("Find most frequent String")
        }

        if (result != null) {
            Text("Most Frequent String: $result", style = MaterialTheme.typography.h6)
        }

        if (error != null) {
            Text(error!!, color = MaterialTheme.colors.error)
        }
    }
}