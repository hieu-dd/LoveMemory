package com.d2b.dev.lovememory.global.util

import com.d2b.dev.lovememory.R

sealed class BottomNavItem(var title: String, var icon: Int, var route: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_home, "home_nav_item_screen")
    object Diary : BottomNavItem("Diary", R.drawable.ic_diary   , "diary_nav_item_screen")
    object Plus : BottomNavItem("Plus", R.drawable.plus_2, "plus_nav_item_screen")
    object Calendar : BottomNavItem("Calendar", R.drawable.ic_calendar, "calendar_nav_item_screen")
    object Menu : BottomNavItem("Menu", R.drawable.ic_menu, "menu_nav_item_screen")
}