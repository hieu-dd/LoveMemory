package com.d2b.dev.lovememory.login.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.d2b.dev.lovememory.data.repository.LoginRepository
import com.d2b.dev.lovememory.global.util.Resource
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {
    private var _loginState: MutableStateFlow<Resource<AuthResult>?> = MutableStateFlow(null)
    var loginState = _loginState.asStateFlow()
    var email: MutableStateFlow<String> = MutableStateFlow("")
    var password: MutableStateFlow<String> = MutableStateFlow("")

    suspend fun loginWithEmail() {
        _loginState.value = loginRepository.loginWithEmail(email.value.orEmpty(), password.value.orEmpty())
    }


}