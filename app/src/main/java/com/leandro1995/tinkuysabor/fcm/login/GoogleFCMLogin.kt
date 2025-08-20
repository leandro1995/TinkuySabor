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

class GoogleFCMLogin {

    fun login(application: Application, method: (GoogleIdTokenCredential) -> Unit) {
        coroutineScope(context = Dispatchers.Main) {
            try {
                credential(getCredentialResponse = credentialManager(application = application)) { googleIdTokenCredential ->
                    method(googleIdTokenCredential)
                }
            } catch (_: Exception) {
            }
        }
    }

    private fun googleIdOption(application: Application) =
        GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(false)
            .setServerClientId(application.getString(R.string.google_id_client)).build()

    private fun request(application: Application): GetCredentialRequest =
        GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption(application = application)).build()

    private suspend fun credentialManager(application: Application) =
        CredentialManager.create(application)
            .getCredential(context = application, request(application = application))

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