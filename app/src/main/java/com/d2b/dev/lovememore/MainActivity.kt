package com.d2b.dev.lovememore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.d2b.dev.lovememore.home.HomeScreen
import com.d2b.dev.lovememore.login.view.LoginScreen
import com.d2b.dev.lovememory.ui.theme.LoveMemoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoveMemoreTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(navController, startDestination = Screen.LoginScreen.route) {
                    composable(route = Screen.LoginScreen.route) {
                        LoginScreen(navController)
                    }
                    composable(route = Screen.SignupScreen.route) {
                        SignupScreen()
                    }
                    composable(route = Screen.HomeScreen.route) {
                        HomeScreen()
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