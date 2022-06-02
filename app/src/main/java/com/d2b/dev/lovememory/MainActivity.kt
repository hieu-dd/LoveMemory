package com.d2b.dev.lovememory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.d2b.dev.lovememory.global.util.Screen
import com.d2b.dev.lovememory.home.EditScreen
import com.d2b.dev.lovememory.home.HomeScreen
import com.d2b.dev.lovememory.login.view.LoginScreen
import com.d2b.dev.lovememory.ui.theme.LoveMemoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoveMemoreTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(navController, startDestination = Screen.HomeScreen.route) {
                    composable(route = Screen.LoginScreen.route) {
                        LoginScreen(navController)
                    }
                    composable(route = Screen.SignupScreen.route) {
                        SignupScreen()
                    }
                    composable(route = Screen.HomeScreen.route) {
                        HomeScreen()
                    }
                    composable (route = Screen.EditInfoScreen.route) {
                        EditScreen()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoveMemoreTheme {
    }
}