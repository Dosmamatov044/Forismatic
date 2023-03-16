package com.example.forismatic.repository

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.forismatic.Model
import com.example.forismatic.retrofit.ApiServices
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class QouteRepository @Inject constructor (val apiServices: ApiServices) {


  fun  getFromRetrofit()=apiServices


    }




