package ru.faimizufarov.yarche.navigation

import ru.faimizufarov.yarche.R

sealed class BottomNavItem(var title: Int, var icon: Int, var screenRoute: String) {
    data object ProgressScreen: BottomNavItem(
        R.string.progress,
        R.drawable.progress_icon,
        "progress_screen"
    )
    data object TestScreen: BottomNavItem(
        R.string.test,
        R.drawable.test_icon,
        "test_screen"
    )
    data object TasksScreen: BottomNavItem(
        R.string.tasks,
        R.drawable.tasks_icon,
        "tasks_screen"
    )
    data object SettingsScreen: BottomNavItem(
        R.string.settings,
        R.drawable.settings_icon,
        "settings_screen"
    )
}