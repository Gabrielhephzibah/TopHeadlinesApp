package com.example.topheadlinesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.topheadlinesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        isFingerPrintOnDevice()
//        useBiometrics()

    }

//   private fun useBiometrics() {
//        BiometricUtils.showBiometricPrompt(
//            activity = this,
//            listener = this,
//            cryptoObject = null,
//            allowAuthenticator = true
//        )
//    }

//    private fun isFingerPrintOnDevice(){
//        if (!BiometricUtils.isBiometricReady(this))
//            BiometricUtils.cancelAuthentication(
//                this,this
//            )
//        //go to next page
//    }

//    override fun onBiometricAuthenticationSuccess(result: BiometricPrompt.AuthenticationResult) {
//        Toast.makeText(this, "Fingerprint success", Toast.LENGTH_SHORT)
//            .show()
//        println( "Fingerprint Success")
//
//        //GO TO THE NEXT PAGE
//
//
//
//    }

//    override fun onBiometricAuthenticationError(errorCode: Int, errorMessage: String) {
//        Toast.makeText(this, "Fingerprint Authentication Error: $errorMessage", Toast.LENGTH_SHORT)
//            .show()
//        println( "Fingerprint Error $errorMessage")
//    }
// //// Todo :: In the error handler.. Change the text on the new Layout you are going to create to show error

}