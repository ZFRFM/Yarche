package ru.faimizufarov.yarche.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.faimizufarov.yarche.ui.screen.HelloScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavItems.HELLO_SCREEN,
        route = NavItems.MAIN_GRAPH,
        modifier = Modifier
    ) {
        navigation(
            startDestination = BottomNavItem.TestScreen.screenRoute,
            route = NavItems.BOTTOM_GRAPH
        ) {
            composable(BottomNavItem.ProgressScreen.screenRoute) {
                TODO("Implement screen")
            }

            composable(BottomNavItem.TestScreen.screenRoute) {
                TODO("Implement screen")
            }

            composable(BottomNavItem.TasksScreen.screenRoute) {
                TODO("Implement screen")
            }

            composable(BottomNavItem.SettingsScreen.screenRoute) {
                TODO("Implement screen")
            }
        }

        composable(NavItems.HELLO_SCREEN) { HelloScreen() }
    }
}