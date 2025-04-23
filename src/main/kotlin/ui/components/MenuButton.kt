package ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun MenuButton(icon: ImageVector, label: String,  selected: Boolean, onClick: () -> Unit) {

    val HighlightColor = Color(0xFFFF7043)
    val textColor = if (selected) HighlightColor else Color.White


        IconButton(onClick = onClick) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, contentDescription = label)
                Spacer(modifier = Modifier.width(4.dp))
                Text(label, color = textColor)
            }
        }

}