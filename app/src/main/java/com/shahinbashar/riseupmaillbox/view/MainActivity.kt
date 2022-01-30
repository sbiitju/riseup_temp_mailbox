package com.shahinbashar.riseupmaillbox.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.shahinbashar.riseupmaillbox.common.ActivitySwape
import com.shahinbashar.riseupmaillbox.databinding.ActivityMainBinding
import com.shahinbashar.riseupmaillbox.utils.shared_preference.SharedPref
import com.shahinbashar.riseupmaillbox.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),ActivitySwape{
    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.model=viewModel
        viewModel.checkLoginStatus()
        var sharedPref=SharedPref(this)
        Log.d("shared",sharedPref.getData().toString())
        setContentView(binding.root)
        supportActionBar?.hide()
    }

    override fun changeIntent() {
    }

}

