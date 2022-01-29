package com.shahinbashar.riseupmaillbox.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.shahinbashar.riseupmaillbox.R
import com.shahinbashar.riseupmaillbox.common.CommonListener
import com.shahinbashar.riseupmaillbox.databinding.FragmentHomeBinding
import com.shahinbashar.riseupmaillbox.databinding.FragmentInboxBinding
import com.shahinbashar.riseupmaillbox.databinding.FragmentLoginBinding
import com.shahinbashar.riseupmaillbox.viewmodel.InboxViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InboxFragment : Fragment() ,CommonListener{
    private lateinit var _viewbinding: FragmentInboxBinding
    val viewbinding get() = _viewbinding
    private val viewmodel by activityViewModels<InboxViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(requireContext(),
            viewmodel.inboxInfo.value?.hydramember?.get(0)?.subject + viewmodel.inboxInfo.value?.hydramember?.get(0)?.from?.address,Toast.LENGTH_LONG).show()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _viewbinding= FragmentInboxBinding.inflate(inflater,container,false)
        return viewbinding.root
    }

    override fun onSuccess(msg: String) {
    }

    override fun onFailed(msg: String) {
    }

    override fun onNavigate() {

    }
}