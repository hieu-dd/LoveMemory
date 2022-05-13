package com.d2b.dev.lovememory.data.remote.firebase

import com.d2b.dev.lovememory.global.util.Resource
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@ActivityScoped
class FireBaseManager @Inject constructor() {
    private val mFireStore = Firebase.firestore
    suspend fun registerUser(email: String, password: String): Resource<AuthResult> = try {
        val response = Firebase.auth.createUserWithEmailAndPassword(email, password).await()
        Resource.Success(response)
    } catch (e: Exception) {
        Resource.Error(e.message ?: "")
    }

    suspend fun loginUser(email: String, password: String): Resource<AuthResult> =
        try {
            val response = Firebase.auth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(data = response)
        } catch (e: Exception) {
            Resource.Error(message = e.message.orEmpty())
        }
}