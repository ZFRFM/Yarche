package ru.faimizufarov.yarche.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.faimizufarov.yarche.R
import ru.faimizufarov.yarche.ui.theme.YarcheTheme

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 12.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
                ) {
                    Text("Имя пользователя")
                    Text("Файми")
                }
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(end = 12.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.edit_icon),
                        contentDescription = null,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSettingsScreen() {
    YarcheTheme {
        SettingsScreen()
    }
}