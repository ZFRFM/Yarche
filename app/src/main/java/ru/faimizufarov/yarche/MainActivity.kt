package ru.faimizufarov.yarche

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ru.faimizufarov.yarche.ui.screen.HelloScreen
import ru.faimizufarov.yarche.ui.theme.YarcheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YarcheTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloScreen(
                        modifier = Modifier.padding(innerPadding),
                        name = "check",
                        onNameChange = {  },
                        onStart = {  }
                    )
                }
            }
        }
    }
}