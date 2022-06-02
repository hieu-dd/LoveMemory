package com.d2b.dev.lovememory.global.util

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object SignupScreen : Screen("signup_screen")
    object HomeScreen : Screen("home_screen")
    object EditInfoScreen : Screen("edit_info_screen")
}
