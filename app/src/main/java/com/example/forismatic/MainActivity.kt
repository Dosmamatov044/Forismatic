package com.example.forismatic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.forismatic.databinding.ActivityMainBinding
import com.example.forismatic.db.QouteDatabase
import com.example.forismatic.retrofit.ApiFactory.apiServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        viewModel.lastQouteLiveData.observe(this){
//            binding.tvQoute.text = viewModel.lastQouteLiveData.value?.quoteText
//           binding.tvAutor.text = viewModel.lastQouteLiveData.value?.quoteAuthor
//                  }


    }
}








