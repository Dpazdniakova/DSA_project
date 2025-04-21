import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.LargestNumScreen

@Composable
@Preview
fun App() {

    MaterialTheme {
        LargestNumScreen()
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication ,
        title = "Algorithms App"
    ) {

        App()
    }
}

