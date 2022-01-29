package com.shahinbashar.riseupmaillbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.viewbinding.ViewBinding
import com.shahinbashar.riseupmaillbox.databinding.ActivityMainBinding
import com.shahinbashar.riseupmaillbox.viewmodel.AccountViewModel
import com.shahinbashar.riseupmaillbox.viewmodel.DomainViewModel
import com.shahinbashar.riseupmaillbox.viewmodel.InboxViewModel
import com.shahinbashar.riseupmaillbox.viewmodel.TokenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(InboxViewModel::class.java)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.inboxInfo.value?.let { Log.d("Final data", it.hydramember.toString()) }
        Log.d("Final data","Shahin Bashar")

    }
}

