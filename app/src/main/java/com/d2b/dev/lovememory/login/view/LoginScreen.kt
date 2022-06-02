package com.d2b.dev.lovememory.login.view

import com.d2b.dev.lovememory.R
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.d2b.dev.lovememory.global.util.Screen
import com.d2b.dev.lovememory.global.util.Resource
import com.d2b.dev.lovememory.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val loginState by viewModel.loginState.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    var isEmailFilled by remember { mutableStateOf(true) }
    var isPasswordFilled by remember { mutableStateOf(true) }
    var showSnackbar by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = loginState) {
        if (loginState is Resource.Error)
            showSnackbar = true
    }

    if (loginState is Resource.Success) {
        navController.navigate(Screen.HomeScreen.route)
    }

    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
                .padding(16.dp)

        ) {
            TopSection()
            //input section
            TextInput(
                hint = stringResource(id = R.string.email),
                showError = !isEmailFilled,
                textError = stringResource(id = R.string.please_enter_your_email)
            ) {
                viewModel.email.value = it
                isEmailFilled = true
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextInput(
                hint = stringResource(id = R.string.password),
                showError = !isPasswordFilled,
                textError = stringResource(id = R.string.please_enter_your_password)
            ) {
//            passWord = it
                viewModel.password.value = it
                isPasswordFilled = true
            }

            Text(
                text = stringResource(id = R.string.forget_password),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                style = MaterialTheme.typography.body2,
                color = DarkGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))

            CustomButton(
                text = stringResource(id = R.string.login),
                backgroundColor = MaterialTheme.colors.primary,
                textColor = MaterialTheme.colors.surface
            ) {
                if (email.isEmpty() || password.isEmpty()) {
                    if (email.isEmpty()) isEmailFilled = false
                    if (password.isEmpty()) isPasswordFilled = false
                } else {
                    isLoading = false
                    scope.launch {
                        viewModel.loginWithEmail()
                        isLoading = true
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 25.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .weight(1f)
                        .background(DarkGray)
                )

                Text(
                    text = stringResource(id = R.string.or),
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(2.dp),
                    color = DarkGray
                )

                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .weight(1f)
                        .background(DarkGray)
                )
            }
            CustomButton(
                text = stringResource(id = R.string.sign_up_with_google),
                textColor = DarkGray,
                modifier = Modifier.padding(bottom = 25.dp)
            ) {
                navController.navigate(Screen.SignupScreen.route)
            }

            CustomButton(
                text = stringResource(id = R.string.sign_up_with_email),
                textColor = DarkGray,
                endIcon = R.drawable.google
            ) {

            }
        }
        if (showSnackbar) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        Brush.horizontalGradient(listOf(Primary, PrimaryYellow))
                    )
                    .align(BottomStart)
                    .padding(horizontal = 5.dp, vertical = 14.dp)
            ) {
                LocalTextInputService.current!!.hideSoftwareKeyboard()
                Text(
                    text = loginState!!.message ?: "Has an Error. Please try again!",
                    color = Color.White
                )
                scope.launch {
                    delay(3000L)
                    showSnackbar = false
                }
            }
        }


        if (!isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DisableBackground),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = Primary,
                    strokeWidth = 8.dp,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}


@Composable
private fun TopSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = stringResource(id = R.string.login),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body2,
            color = if (isSystemInDarkTheme()) OnSurfaceDarkMode else OnSurfaceLightMode,
            modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(id = R.string.welcome_back),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .padding(top = 16.dp)
        )

        Text(
            text = stringResource(id = R.string.sign_in_to_continue),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            style = MaterialTheme.typography.body2,
            color = DarkGray,
            modifier = Modifier
                .padding(vertical = 5.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
    }
}


@Preview
@Composable
fun Preview() {
}