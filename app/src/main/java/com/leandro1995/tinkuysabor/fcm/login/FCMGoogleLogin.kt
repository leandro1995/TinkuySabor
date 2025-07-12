package com.leandro1995.tinkuysabor.fcm.login

import android.app.Application
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.extension.coroutineScope
import kotlinx.coroutines.Dispatchers

class FCMGoogleLogin(private val application: Application) {

    fun login(method: (GoogleIdTokenCredential) -> Unit) {
        coroutineScope(context = Dispatchers.Main) {
            try {
                credential(getCredentialResponse = credentialManager()) { googleIdTokenCredential ->
                    method(googleIdTokenCredential)
                }
            } catch (_: Exception) {
            }
        }
    }

    private fun googleIdOption() = GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(false)
        .setServerClientId(application.getString(R.string.google_id_client)).build()

    private fun request(): GetCredentialRequest =
        GetCredentialRequest.Builder().addCredentialOption(googleIdOption()).build()

    private suspend fun credentialManager() =
        CredentialManager.create(application).getCredential(context = application, request())

    private fun credential(
        getCredentialResponse: GetCredentialResponse,
        method: (googleIdTokenCredential: GoogleIdTokenCredential) -> Unit
    ) {
        val credential = getCredentialResponse.credential

        when (credential) {
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        method(GoogleIdTokenCredential.createFrom(credential.data))
                    } catch (_: GoogleIdTokenParsingException) {
                    }
                }
            }
        }
    }
}