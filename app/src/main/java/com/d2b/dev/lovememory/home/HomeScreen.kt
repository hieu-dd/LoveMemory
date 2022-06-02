package com.d2b.dev.lovememory.home

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.d2b.dev.lovememory.global.util.BottomNavItem
import com.d2b.dev.lovememory.ui.theme.Primary
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.d2b.dev.lovememory.ui.theme.PrimaryBackground
import com.d2b.dev.lovememory.ui.theme.SelectedPrimary
import com.d2b.dev.lovememory.ui.theme.UnselectedPrimary

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) },
        backgroundColor = PrimaryBackground
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route
        ) {
            composable(route = BottomNavItem.Home.route) {
                EditScreen()
            }
            composable(route = BottomNavItem.Diary.route) {
                DiaryScreen()
            }
            composable(route = BottomNavItem.Calendar.route) {
                HomeScreen()
            }
            composable(route = BottomNavItem.Menu.route) {
                HomeScreen()
                2
            }
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Diary,
        BottomNavItem.Plus,
        BottomNavItem.Calendar,
        BottomNavItem.Menu
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .size(if (item.title != BottomNavItem.Plus.title) 32.dp else 60.dp)
                            .padding(vertical = 5.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body1
                    )
                },
                selectedContentColor = SelectedPrimary,
                unselectedContentColor = UnselectedPrimary,
                alwaysShowLabel = item.title != BottomNavItem.Plus.title,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}