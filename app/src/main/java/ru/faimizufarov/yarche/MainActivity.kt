package ru.faimizufarov.yarche

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.faimizufarov.yarche.navigation.AppNavHost
import ru.faimizufarov.yarche.navigation.BottomNavItem
import ru.faimizufarov.yarche.navigation.YarcheNavigationBar
import ru.faimizufarov.yarche.ui.screen.HelloScreenBase
import ru.faimizufarov.yarche.ui.theme.YarcheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YarcheTheme {
                val navController = rememberNavController()
                val currentRoute = navController
                    .currentBackStackEntryAsState()
                    .value
                    ?.destination
                    ?.route

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (
                            BottomNavItem.ProgressScreen.screenRoute == currentRoute ||
                            BottomNavItem.TestScreen.screenRoute == currentRoute ||
                            BottomNavItem.TasksScreen.screenRoute == currentRoute ||
                            BottomNavItem.SettingsScreen.screenRoute == currentRoute
                        ) YarcheNavigationBar(
                            navController = navController
                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavHost(navController)
                    }
                }
            }
        }
    }
}