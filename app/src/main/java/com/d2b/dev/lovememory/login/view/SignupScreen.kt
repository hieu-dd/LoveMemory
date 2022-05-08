package com.d2b.dev.lovememory

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.d2b.dev.lovememory.login.view.SignupScreenViewModel
import com.d2b.dev.lovememory.ui.theme.CustomButton
import com.d2b.dev.lovememory.ui.theme.TextInput
import com.d2b.dev.lovememory.ui.theme.TopSection
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun SignupScreen() {
    val viewModel: SignupScreenViewModel = viewModel()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .padding(16.dp)
    ) {
        TopSection(
            title = stringResource(id = R.string.sign_up),
            hasArrowBack = true
        )
        Spacer(modifier = Modifier.height(30.dp))
        InputSection(viewModel)
    }
}

@Composable
fun InputSection(viewModel: SignupScreenViewModel) {
    var isVerifiedPassword by remember { mutableStateOf(false) }
    Column {
        TextInput(hint = stringResource(id = R.string.user_name)) {
//            userName = it
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextInput(hint = stringResource(id = R.string.password)) {
//            password = it
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextInput(hint = stringResource(id = R.string.verify_your_password)) {
//            isVerifiedPassword = it == password
        }
        Spacer(modifier = Modifier.height(30.dp))
        CustomButton(
            text = stringResource(id = R.string.sign_up),
            backgroundColor = MaterialTheme.colors.primary
        ) {
        }
    }
}

@Preview
@Composable
fun Preview() {
    SignupScreen()
}