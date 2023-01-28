package com.example.topheadlinesapp.ui.biometric

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.topheadlinesapp.R
import com.example.topheadlinesapp.databinding.FragmentBiometricBinding
import com.example.topheadlinesapp.utils.BiometricUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BiometricFragment : Fragment(), BiometricAuthListener {
    private var _binding: FragmentBiometricBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBiometricBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isFingerPrintOnDevice()
        useBiometrics()
    }

    private fun isFingerPrintOnDevice(){
        if (!BiometricUtils.isBiometricReady(requireContext()))
            findNavController().navigate(
                BiometricFragmentDirections.actionBiometricFragmentToHeadlinesFragment()
            )
    }

    private fun useBiometrics() {
        BiometricUtils.showBiometricPrompt(
            activity = this,
            listener = this,
            cryptoObject = null,
            allowAuthenticator = true
        )
    }

    override fun onResume() {
        super.onResume()
        println("ONRESUME")
        isFingerPrintOnDevice()
        useBiometrics()
        binding.message.text = getString(R.string.fingerprint_message)
        binding.fingerprintIcon.setImageResource(R.drawable.baseline_fingerprint)
    }


    override fun onBiometricAuthenticationSuccess(result: BiometricPrompt.AuthenticationResult) {
        Toast.makeText(requireContext(), "Fingerprint success", Toast.LENGTH_SHORT)
            .show()
        findNavController().navigate(
            BiometricFragmentDirections.actionBiometricFragmentToHeadlinesFragment()
        )

        println( "Fingerprint Success")
    }

    override fun onBiometricAuthenticationError(errorCode: Int, errorMessage: String) {
        Toast.makeText(requireContext(), "Fingerprint Authentication Error: $errorMessage", Toast.LENGTH_SHORT)
            .show()
        binding.fingerprintIcon.setImageResource(R.drawable.ic_error_outline)
        if(errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON)
            binding.message.text = getString(R.string.fingerprint_error)
        else
            binding.message.text = errorMessage
        println( "Fingerprint Error $errorMessage")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}