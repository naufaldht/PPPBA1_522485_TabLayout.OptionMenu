package com.example.tablayout

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tablayout.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    companion object {
        const val ARG_EMAIL = "email"
        const val ARG_PASSWORD = "password"

        fun newInstance(email: String, password: String): LoginFragment {
            val fragment = LoginFragment()
            val args = Bundle()
            args.putString(ARG_EMAIL, email)
            args.putString(ARG_PASSWORD, password)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get registered email and password from arguments
        val registeredEmail = arguments?.getString(ARG_EMAIL)
        val registeredPassword = arguments?.getString(ARG_PASSWORD)

        with(binding) {
            loginButton.setOnClickListener {
                val inputEmail = usernameEditText.text.toString()
                val inputPassword = passwordLoginText.text.toString()

                // Check if entered email and password match the registered ones
                if (inputEmail == registeredEmail && inputPassword == registeredPassword) {
                    // If matched, move to ThirdActivity
                    val intent = Intent(requireActivity(), ThirdActivity::class.java)
                    intent.putExtra("EXTRA_EMAIL", inputEmail)
                    intent.putExtra("EXTRA_PASSWORD", inputPassword)
                    startActivity(intent)
                } else {
                    // Show error message
                    Toast.makeText(requireContext(), "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
