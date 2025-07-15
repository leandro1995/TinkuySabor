package com.leandro1995.tinkuysabor.fcm.authentication

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth

class FCMGoogleAuthentication(private val googleToken: String) {

    private val authentication = Firebase.auth

    fun registerUser(success: (currentUser: FirebaseUser) -> Unit, error: () -> Unit) {
        authentication.let { auth ->
            auth.signInWithCredential(GoogleAuthProvider.getCredential(googleToken, null))
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        auth.currentUser?.let { currentUser ->
                            success(currentUser)
                        }
                    } else {
                        error()
                    }
                }
        }
    }
}