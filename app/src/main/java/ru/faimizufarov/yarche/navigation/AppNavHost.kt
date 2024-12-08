package ru.faimizufarov.yarche.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.faimizufarov.yarche.ui.screen.HelloScreen
import ru.faimizufarov.yarche.ui.screen.HelloViewModel
import ru.faimizufarov.yarche.ui.screen.ProgressScreen
import ru.faimizufarov.yarche.ui.screen.SettingsScreen
import ru.faimizufarov.yarche.ui.screen.TasksScreen
import ru.faimizufarov.yarche.ui.screen.TestScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    helloViewModel: HelloViewModel = hiltViewModel()
) {
    val isUserNamePresent by helloViewModel.isNamePresent.collectAsState()

    val startDestination =
        if (isUserNamePresent == true) NavItems.BOTTOM_GRAPH
        else  NavItems.HELLO_SCREEN

    if (isUserNamePresent == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            route = NavItems.MAIN_GRAPH,
            modifier = Modifier
        ) {
            navigation(
                startDestination = BottomNavItem.TestScreen.screenRoute,
                route = NavItems.BOTTOM_GRAPH
            ) {
                composable(BottomNavItem.ProgressScreen.screenRoute) {
                    ProgressScreen()
                }

                composable(BottomNavItem.TestScreen.screenRoute) {
                    TestScreen()
                }

                composable(BottomNavItem.TasksScreen.screenRoute) {
                    TasksScreen()
                }

                composable(BottomNavItem.SettingsScreen.screenRoute) {
                    SettingsScreen()
                }
            }

            composable(NavItems.HELLO_SCREEN) {
                HelloScreen(
                    navController = navController
                )
            }
        }
    }
}