package ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun MenuButton(icon: ImageVector, label: String, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Row {
            Icon(imageVector = icon, contentDescription = label)
            Spacer(modifier = Modifier.width(4.dp))
            Text(label, color = Color.White, modifier = Modifier.padding(top = 2.dp))
        }
    }
}
