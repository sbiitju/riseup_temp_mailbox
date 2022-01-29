package com.shahinbashar.riseupmaillbox.view.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shahinbashar.riseupmaillbox.R
import com.shahinbashar.riseupmaillbox.databinding.FragmentHomeBinding
import com.shahinbashar.riseupmaillbox.view.MainActivity
import com.shahinbashar.riseupmaillbox.viewmodel.DomainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var _viewbinding: FragmentHomeBinding
    val viewbinding get() = _viewbinding
    var domainName=MutableLiveData<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel= ViewModelProvider(this)[DomainViewModel::class.java]
        domainName.postValue(viewModel.responseDomain.value.toString())
        _viewbinding= FragmentHomeBinding.inflate(inflater,container,false)
        viewbinding.homeBtn.setOnClickListener{
            val action=HomeFragmentDirections.actionHomeFragmentToRegistrationFragment(viewModel.responseDomain.value?.hydramember?.get(0)?.domain.toString())
            findNavController().navigate(action)
        }
        return viewbinding.root
    }

}