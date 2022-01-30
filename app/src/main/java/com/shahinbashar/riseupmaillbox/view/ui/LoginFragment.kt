package com.shahinbashar.riseupmaillbox.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shahinbashar.riseupmaillbox.common.CommonListener
import com.shahinbashar.riseupmaillbox.databinding.FragmentLoginBinding
import com.shahinbashar.riseupmaillbox.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() ,CommonListener{
    private lateinit var _viewbinding: FragmentLoginBinding
    val viewbinding get() = _viewbinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var viewModel: LoginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        _viewbinding= FragmentLoginBinding.inflate(inflater,container,false)
        viewbinding.model=viewModel
        viewbinding.lifecycleOwner=this
        viewModel.commonListener=this
        return viewbinding.root
    }

    override fun onSuccess(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()

    }

    override fun onFailed(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onNavigate() {
        val action=LoginFragmentDirections.actionLoginFragmentToInboxFragment()
        findNavController().navigate(action)
    }

}