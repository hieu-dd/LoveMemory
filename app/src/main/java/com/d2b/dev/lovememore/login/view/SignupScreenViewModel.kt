package com.d2b.dev.lovememore.login.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignupScreenViewModel : ViewModel() {
    val userName = mutableStateOf("")
    val passWord = mutableStateOf("")
}