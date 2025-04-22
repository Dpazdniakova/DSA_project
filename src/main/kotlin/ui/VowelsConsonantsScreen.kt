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
import utils.countVowelsAndConsonants

@Composable
fun VowelsConsonantsScreen () {

    var userInput by remember { mutableStateOf("") }
    var vowelCount by remember { mutableStateOf<Int?>(null) }
    var consonantCount by remember { mutableStateOf<Int?>(null) }
    var error by remember { mutableStateOf <String?>(null) }
    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter a string to count vowels and consonants:")

        TextField(
            value = userInput,
            onValueChange = {
                userInput = it
                vowelCount = null
                consonantCount = null
                error = null
            },
            placeholder = { Text("e.g. Hello World") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Button(onClick = {
            if (userInput.isNotBlank()  ) {
                val (vowels, consonants) = countVowelsAndConsonants(userInput)
                vowelCount = vowels
                consonantCount = consonants
            }
            else {
                error = "Invalid input. Please enter a valid string."
            }

        }) {
            Text("Count Vowels & Consonants")
        }

        if (vowelCount != null && consonantCount != null) {
            Text("Vowels: $vowelCount", style = MaterialTheme.typography.h6)
            Text("Consonants: $consonantCount", style = MaterialTheme.typography.h6)
        }
        if (error != null) {
            Text(error!!, color = MaterialTheme.colors.error)
        }
    }
}