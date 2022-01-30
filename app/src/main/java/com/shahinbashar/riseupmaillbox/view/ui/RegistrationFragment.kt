package com.shahinbashar.riseupmaillbox.view.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shahinbashar.riseupmaillbox.R
import com.shahinbashar.riseupmaillbox.common.CommonListener
import com.shahinbashar.riseupmaillbox.databinding.FragmentRegistrationBinding
import com.shahinbashar.riseupmaillbox.viewmodel.AccountViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment(),CommonListener{
    private val args:RegistrationFragmentArgs by navArgs()
    private lateinit var _viewbinding: FragmentRegistrationBinding
    val viewbinding get() = _viewbinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var viewModel:AccountViewModel=ViewModelProvider(this)[AccountViewModel::class.java]
        _viewbinding= FragmentRegistrationBinding.inflate(inflater,container,false)
        viewbinding.model=viewModel
        viewbinding.lifecycleOwner=this
        viewModel.commonListener=this
        viewbinding.emailET.hint="Email: (ex: xyz@${args.domainName.toString()})"
        viewbinding.domainNameTV.text="Your Domain Name is : "+args.domainName.toString()
        return viewbinding.root
    }

    override fun onSuccess(msg:String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
//        val action=RegistrationFragmentDirections.actionRegistrationFragmentToInboxFragment()
//        findNavController().navigate(action)
    }

    override fun onFailed(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onNavigate() {
        val action=RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
        findNavController().navigate(action)
    }

}