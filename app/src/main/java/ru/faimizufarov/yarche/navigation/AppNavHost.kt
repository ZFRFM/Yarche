package ru.faimizufarov.yarche.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.faimizufarov.yarche.ui.screen.HelloScreen
import ru.faimizufarov.yarche.ui.screen.ProgressScreen
import ru.faimizufarov.yarche.ui.screen.SettingsScreen
import ru.faimizufarov.yarche.ui.screen.TasksScreen
import ru.faimizufarov.yarche.ui.screen.TestScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavItems.HELLO_SCREEN,
        route = NavItems.MAIN_GRAPH,
        modifier = Modifier
    ) {
        navigation(
            startDestination = BottomNavItem.SettingsScreen.screenRoute,
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