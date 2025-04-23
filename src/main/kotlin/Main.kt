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
                    Text(text = "Menu",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White
                    ) },
                actions = {
                    MenuButton(Icons.Filled.FormatListNumbered, "Biggest number") { selectedMenuItem = MenuItem.Numbers }
                    Spacer(modifier = Modifier.width(width = 16.dp))
                    MenuButton(Icons.Filled.Abc, "Characters count") { selectedMenuItem = MenuItem.Vowels }
                    Spacer(modifier = Modifier.width(width = 16.dp))
                    MenuButton(Icons.Filled.Abc, "Palindrome") { selectedMenuItem = MenuItem.Palindrome }
                    Spacer(modifier = Modifier.width(width = 16.dp))
                    MenuButton(Icons.Filled.Equalizer, "Frequency") { selectedMenuItem = MenuItem.FrequentString }
                    Spacer(modifier = Modifier.width(width = 16.dp))
                    MenuButton(Icons.Filled.Equalizer, "Needle in Haystack") { selectedMenuItem = MenuItem.countOccurrences }
                    Spacer(modifier = Modifier.width(width = 16.dp))
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

