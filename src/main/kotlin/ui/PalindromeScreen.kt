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
import utils.isPalindrome

@Composable
fun PalindromeScreen() {

    var userInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter a string to find out if its a palindrome:")

        TextField(
            value = userInput,
            onValueChange = {
                userInput = it
                result = null
            },
            placeholder = { Text("e.g. Hello World") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Button(onClick = {
            result = isPalindrome(userInput).toString()

        }) {
            Text("Find out")
        }

        if (result != null) {
            Text("Is it a palindrome: $result", style = MaterialTheme.typography.h6)
        }

    }

}
