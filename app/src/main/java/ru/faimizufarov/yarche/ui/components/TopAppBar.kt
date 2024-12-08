package ru.faimizufarov.yarche.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YarcheTopAppBar(screenName: String) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = screenName,
                modifier = Modifier,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        },
        colors = TopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            scrolledContainerColor = Color.Transparent,
            navigationIconContentColor = Color(0xFF444748),
            titleContentColor = Color.Transparent,
            actionIconContentColor = Color.Transparent
        )
    )
}

@Preview
@Composable
fun PreviewYarcheTopAppBar() {
    YarcheTopAppBar("Проверка")
}