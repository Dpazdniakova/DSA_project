package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.ErrorPopUp
import utils.findLargestNumber

@Composable
fun LargestNumScreen() {

    var userInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }
    var error by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter numbers separated by commas:")

        TextField(
            value = userInput,
            onValueChange = {
                userInput = it
                result = null
                error = null
            },
            placeholder = { Text("e.g. 3,5,1,9") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Button(onClick = {
            try {
                val numberList = userInput
                    .split(",")
                    .map { it.trim().toInt() }

                val largest = findLargestNumber(numberList)
                result = largest?.toString()
            } catch (e: Exception) {
                error = "Invalid input. Please enter valid integers separated by commas."
            }
        }) {
            Text("Find Largest Number")
        }

        if (result != null) {
            Text("Largest Number: $result", style = MaterialTheme.typography.h6)
        }

        if (error != null) {
            ErrorPopUp(message = error!!, onDismiss = { error = null })
        }
    }

}
