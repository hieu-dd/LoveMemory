package com.d2b.dev.lovememore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d2b.dev.lovememore.login.view.SignupScreenViewModel
import com.d2b.dev.lovememore.ui.theme.CustomButton
import com.d2b.dev.lovememore.ui.theme.TextInput
import com.d2b.dev.lovememore.ui.theme.TopSection


@Composable
fun SignupScreen() {
    val viewModel = SignupScreenViewModel()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .padding(16.dp)
    ) {
        TopSection(title = "Sign Up", true)
        Spacer(modifier = Modifier.height(30.dp))
        InputSection(viewModel)
    }
}

@Composable
fun InputSection(viewModel: SignupScreenViewModel) {
    var userName by remember { viewModel.userName }
    var password by remember { viewModel.userName }
    var isVerifiedPassword by remember { mutableStateOf(false) }
    Column {
        TextInput(hint = "User name") {
            userName = it
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextInput(hint = "Password") {
            password = it
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextInput(hint = "Verify your password") {
            isVerifiedPassword = it == password
        }
        Spacer(modifier = Modifier.height(30.dp))

        CustomButton(text = "Sign Up", backgroundColor = MaterialTheme.colors.primary) {
        }
    }
}

@Preview
@Composable
fun Preview() {
    SignupScreen()
}