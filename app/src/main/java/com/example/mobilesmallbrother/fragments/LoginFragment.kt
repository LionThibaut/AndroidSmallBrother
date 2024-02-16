package com.example.mobilesmallbrother.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobilesmallbrother.databinding.FragmentLoginUserBinding
import com.example.mobilesmallbrother.dtos.DtoInputClient

import com.example.mobilesmallbrother.dtos.DtoOutputLoginClient
import com.example.mobilesmallbrother.managers.ClientManagerViewModel

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginUserBinding
    lateinit var viewModel: ClientManagerViewModel
    private var callbackOnSubmit: ((dtoClient: DtoInputClient) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginUserBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(ClientManagerViewModel::class.java)

        viewModel.mutableLiveDataLoginClient.observe(viewLifecycleOwner) {
            if(viewModel.acceptLogin) {
                if (it != null) {
                    callbackOnSubmit?.invoke(it)
                }
                Toast.makeText(activity, "Bienvenue " + it?.firstName + " !", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(activity, "Identifiants incorrects", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnLoginFragmentConnection.setOnClickListener {
            val clientLogin = DtoOutputLoginClient(
                binding.etLoginFragmentMail.text.toString(), binding.etLoginFragmentConnection.text.toString())

            viewModel.launchFetchByLogin(clientLogin)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ClientManagerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        @JvmStatic
        fun newInstance(callback: ((dtoClient: DtoInputClient) -> Unit)) = LoginFragment().apply {
            callbackOnSubmit = callback
        }
    }
}

