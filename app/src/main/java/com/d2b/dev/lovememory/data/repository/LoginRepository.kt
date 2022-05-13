package com.d2b.dev.lovememory.data.repository

import com.d2b.dev.lovememory.data.remote.firebase.FireBaseManager
import com.d2b.dev.lovememory.global.util.Resource
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class LoginRepository @Inject constructor(
    private val firebaseManager: FireBaseManager
) {
    suspend fun registerWithEmail(email: String, password: String): Resource<AuthResult> =
        firebaseManager.registerUser(email, password)

    suspend fun loginWithEmail(email: String, password: String): Resource<AuthResult> =
        firebaseManager.loginUser(email, password)
}