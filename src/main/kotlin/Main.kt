import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
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
import ui.components.MenuButton
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
                    Text("Menu", style = MaterialTheme.typography.headlineSmall, color = Color.White)
                },
                actions = {
                    MenuButton(
                        icon = Icons.Filled.FormatListNumbered,
                        label = "Biggest number",
                        selected = selectedMenuItem == MenuItem.Numbers,
                        onClick = { selectedMenuItem = MenuItem.Numbers }
                    )

                    Spacer(Modifier.width(8.dp))

                    MenuButton(
                        icon = Icons.Filled.Abc,
                        label = "Characters count",
                        selected = selectedMenuItem == MenuItem.Vowels,
                        onClick = { selectedMenuItem = MenuItem.Vowels }
                    )

                    Spacer(Modifier.width(8.dp))

                    MenuButton(
                        icon = Icons.Filled.Abc,
                        label = "Palindrome",
                        selected = selectedMenuItem == MenuItem.Palindrome,
                        onClick = { selectedMenuItem = MenuItem.Palindrome }
                    )

                    Spacer(Modifier.width(8.dp))

                    MenuButton(
                        icon = Icons.Filled.Equalizer,
                        label = "Frequency",
                        selected = selectedMenuItem == MenuItem.FrequentString,
                        onClick = { selectedMenuItem = MenuItem.FrequentString }
                    )

                    Spacer(Modifier.width(8.dp))

                    MenuButton(
                        icon = Icons.Filled.Equalizer,
                        label = "Needle in Haystack",
                        selected = selectedMenuItem == MenuItem.countOccurrences,
                        onClick = { selectedMenuItem = MenuItem.countOccurrences }
                    )
                }
            )

        },
        content = {
            when (selectedMenuItem) {
                MenuItem.Numbers -> LargestNumScreen()
                MenuItem.Vowels -> VowelsConsonantsScreen()
                MenuItem.Palindrome -> PalindromeScreen()
                MenuItem.FrequentString -> FrequencyCounterScreen()
                MenuItem.countOccurrences -> countOccurrencesScreen()
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

