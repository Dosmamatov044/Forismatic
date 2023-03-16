package com.example.forismatic

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.forismatic.db.QouteDatabase
import com.example.forismatic.repository.QouteRepository
import com.example.forismatic.retrofit.ApiFactory
import com.example.forismatic.retrofit.ApiServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject


@HiltViewModel
class QouteViewModel @Inject constructor(val repository: QouteRepository,application: Application): AndroidViewModel(application) {

    var dataDb:QouteDatabase?=null

    val data=MutableLiveData<Model>()





    init {

         dataDb=QouteDatabase.getInstance(application)



    }






   val lastData=     dataDb?.qouteDao()?.getLastQoute()





    val listData=     dataDb?.qouteDao()?.getAllQoute()






    fun setToRoom(context:Application){

        val dataDb=QouteDatabase.getInstance(context)

        data.observeForever {
        viewModelScope.launch {






                dataDb.qouteDao().saveQoute(it)

            }


        }




    }





  fun  getFromRetrofit(){

      viewModelScope.launch {
          val apiData=repository.apiServices.getQuote()

          try {
              if (apiData.isSuccessful){

                  data.value=apiData.body()
              }else{

                  Log.d("ololo",apiData.errorBody()?.string().toString())

              }



          }catch (e:Exception){

              Log.d("ololo",e.message.toString())

          }






      }









   }
















}