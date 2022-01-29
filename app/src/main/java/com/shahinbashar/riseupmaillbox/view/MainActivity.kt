package com.shahinbashar.riseupmaillbox.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.shahinbashar.riseupmaillbox.databinding.ActivityMainBinding
import com.shahinbashar.riseupmaillbox.viewmodel.InboxViewModel
import com.shahinbashar.riseupmaillbox.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(InboxViewModel::class.java)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        viewModel?.inboxInfo?.value?.let { Log.d("Result", it.toString()) }
    }
}

