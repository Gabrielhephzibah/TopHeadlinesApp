package com.example.topheadlinesapp.utils

import android.content.Context
import android.util.Log
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_WEAK
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.topheadlinesapp.ui.biometric.BiometricAuthListener

object BiometricUtils {
    private fun isBiometricConfigured(context: Context): Int {
        val biometricManager = BiometricManager.from(context)
        return biometricManager.canAuthenticate(BIOMETRIC_STRONG or BIOMETRIC_WEAK)
    }

    fun isBiometricReady(context: Context) =
        isBiometricConfigured(context) == BiometricManager.BIOMETRIC_SUCCESS

    private fun setBiometricPromptInfo(
        title: String,
        subtitle: String,
        allowAuthenticator: Boolean
    ): BiometricPrompt.PromptInfo {
        val builder = BiometricPrompt.PromptInfo.Builder().apply {
            setTitle(title)
            setSubtitle(subtitle)
            setAllowedAuthenticators(BIOMETRIC_STRONG or BIOMETRIC_WEAK)
            setNegativeButtonText("Cancel")

        }

        return builder.build()
    }

    private fun initializeBiometricPrompt(
        activity: Fragment,
        listener: BiometricAuthListener
    ): BiometricPrompt {

        val executor = ContextCompat.getMainExecutor(activity.requireContext())


        val callback = object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                listener.onBiometricAuthenticationError(errorCode, errString.toString())
                println("ERROR:::: $errorCode, $errString")
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                listener.onBiometricAuthenticationError(
                    -1,
                    "Authentication failed for an unknown reason"
                )
                Log.w(this.javaClass.simpleName, "Authentication failed for an unknown reason")
                println("FAILED:::: #HERE IS FAILED")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                listener.onBiometricAuthenticationSuccess(result)
                println("SUCCESS:::: $result")
            }
        }
        return BiometricPrompt(activity, executor, callback)
    }

    fun showBiometricPrompt(
        title: String = "Verify your identity",
        subtitle: String = "Use your fingerprint to verify your identity.",
        activity: Fragment,
        listener: BiometricAuthListener,
        cryptoObject: BiometricPrompt.CryptoObject? = null,
        allowAuthenticator : Boolean = false
    ) {
        val promptInfo = setBiometricPromptInfo(
            title,
            subtitle,
            allowAuthenticator
        )

        val biometricPrompt = initializeBiometricPrompt(activity, listener)

        biometricPrompt.apply {
            if (cryptoObject == null) authenticate(promptInfo)
            else authenticate(promptInfo, cryptoObject)
        }
    }

    fun cancelAuthentication(
        activity: Fragment,
        listener: BiometricAuthListener
    ){
        val biometricPrompt = initializeBiometricPrompt(activity, listener)
        biometricPrompt.cancelAuthentication()
    }

}