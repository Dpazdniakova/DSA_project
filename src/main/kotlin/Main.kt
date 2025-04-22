import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.runtime.*
import androidx.compose.material3.MaterialTheme
import ui.VowelsConsonantsScreen
import ui.*
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.Equalizer
import androidx.compose.ui.graphics.Color


@Composable
@Preview
fun App() {

    var selectedMenuItem by remember { mutableStateOf<MenuItem?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Menu",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White
                    ) },
                actions = {
                    IconButton(onClick = { selectedMenuItem = MenuItem.Numbers }) {
                        Row() {
                            Icon(
                                imageVector = Icons.Filled.FormatListNumbered,
                                contentDescription = "Numbered List"
                            )
                            Spacer(modifier = Modifier.width(width = 4.dp))
                            Text("Biggest number",
                                color = Color.White,
                                modifier = Modifier.padding(top = 2.dp))
                        }
                    }
                    Spacer(modifier = Modifier.width(width = 16.dp))

                    IconButton(onClick = { selectedMenuItem = MenuItem.Vowels }) {
                        Row() {
                            Icon(
                                imageVector = Icons.Filled.Abc,
                                contentDescription = "Characters"
                            )
                            Spacer(modifier = Modifier.width(width = 4.dp))
                            Text("Characters count",
                                color = Color.White,
                                modifier = Modifier.padding(top = 2.dp))
                        }
                    }
                    Spacer(modifier = Modifier.width(width = 16.dp))


                    IconButton(onClick = { selectedMenuItem = MenuItem.Palindrome }) {
                        Row() {
                            Icon(
                                imageVector = Icons.Filled.Abc,
                                contentDescription = "Palindrome"
                            )
                            Spacer(modifier = Modifier.width(width = 4.dp))
                            Text("Palindrome",
                                color = Color.White,
                                modifier = Modifier.padding(top = 2.dp))
                        }
                    }

                    Spacer(modifier = Modifier.width(width = 16.dp))


                    IconButton(onClick = { selectedMenuItem = MenuItem.FrequentString }) {
                        Row() {
                            Icon(
                                imageVector = Icons.Filled.Equalizer,
                                contentDescription = "Frequency"
                            )
                            Spacer(modifier = Modifier.width(width = 4.dp))
                            Text("Frequency",
                                color = Color.White,
                                modifier = Modifier.padding(top = 2.dp))
                        }
                    }

                }
            )
        },
        content = {
            when (selectedMenuItem) {
                MenuItem.Numbers -> LargestNumScreen()
                MenuItem.Vowels -> VowelsConsonantsScreen()
                MenuItem.Palindrome -> PalindromeScreen()
                MenuItem.FrequentString -> FrequencyCounterScreen()
                else -> LargestNumScreen()
            }
        }
    )
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication ,
        title = "Algorithms App"
    ) {

        App()
    }
}

