package com.d2b.dev.lovememory.login.view

import com.d2b.dev.lovememory.R
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.d2b.dev.lovememory.Screen
import com.d2b.dev.lovememory.ui.theme.*

@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: LoginScreenViewModel = viewModel()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .padding(16.dp)

    ) {
        TopSection()
        InputSection(viewModel)

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
            text = stringResource(id = R.string.login_title),
            backgroundColor = MaterialTheme.colors.primary,
            textColor = MaterialTheme.colors.surface
        ) {
            navController.navigate(Screen.HomeScreen.route)
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
            text = stringResource(id = R.string.sign_up_with_email),
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

@Composable
fun InputSection(
    viewModel: LoginScreenViewModel,
    userNameHint: String = stringResource(id = R.string.user_name),
    passwordHint: String = stringResource(id = R.string.password)
) {
//    var userName by remember { viewModel.userName }
//    var passWord by remember { viewModel.passWord }
    Column {
        TextInput(hint = userNameHint) {
//            userName = it
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextInput(hint = passwordHint) {
//            passWord = it
        }
    }
}

@Preview
@Composable
fun Preview() {
}