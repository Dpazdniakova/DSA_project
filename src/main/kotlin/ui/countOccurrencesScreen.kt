package ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.ErrorPopUp
import utils.countOccurrences

@Composable
fun countOccurrencesScreen() {

    var haystackInput by remember { mutableStateOf("") }
    var needleInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Int?>(null) }
    var error by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter the haystack string:")
        TextField(
            value = haystackInput,
            onValueChange = {
                haystackInput = it
                result = null
                error = null
            },
            placeholder = { Text("e.g. banana") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Text("Enter the needle substring to search for:")
        TextField(
            value = needleInput,
            onValueChange = {
                needleInput = it
                result = null
                error = null
            },
            placeholder = { Text("e.g. na") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Button(onClick = {
            val haystack = haystackInput.trim()
            val needle = needleInput.trim()

            if (haystack.isBlank() || needle.isBlank()) {
                    error = "Both fields must be filled in."
                    result = null
                } else {
                    val count = countOccurrences(haystack, needle)
                    result = count
                }
            }
        )
            {
            Text("Count Occurrences")
        }
        if (result != null) {
            Text("Occurrences: $result", style = MaterialTheme.typography.h6)
        }

        if (error != null) {
            ErrorPopUp(message = error!!, onDismiss = { error = null })
        }
    }
}