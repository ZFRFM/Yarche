package ru.faimizufarov.yarche.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.faimizufarov.yarche.ui.theme.YarcheTheme

@Composable
fun YarcheNavigationBar(
    navController: NavController
) {
    val navigationBarItems = listOf(
        BottomNavItem.ProgressScreen,
        BottomNavItem.TestScreen,
        BottomNavItem.TasksScreen,
        BottomNavItem.SettingsScreen
    )

    Column(
        modifier = Modifier
    ) {
        HorizontalDivider(color = MaterialTheme.colorScheme.background, thickness = 1.dp)

        NavigationBar(
            modifier = Modifier,
            containerColor = MaterialTheme.colorScheme.background
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            navigationBarItems.forEach { item ->
                val isSelected = currentRoute == item.screenRoute
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(item.icon),
                            contentDescription = stringResource(id = item.title),
                            tint = if (isSelected) Color(0xFFFF9025) else Color(0xFF444748),
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = item.title),
                            color = if (isSelected) Color(0xFFFF9025) else Color(0xFF444748)
                        )
                    },
                    selected = isSelected,
                    onClick = {
                        navController.navigate(item.screenRoute) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent),
                    modifier = Modifier
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewNavigationBar() {
    YarcheTheme {
        val navController = rememberNavController()
        YarcheNavigationBar(navController)
    }
}