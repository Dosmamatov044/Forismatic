package com.example.forismatic

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.forismatic.db.QouteDatabase
import com.example.forismatic.retrofit.ApiFactory
import kotlinx.coroutines.launch

class QouteViewModel(application: Application): AndroidViewModel(application) {

    var dataDb:QouteDatabase?=null

    val data=MutableLiveData<Model>()





    init {

         dataDb=QouteDatabase.getInstance(application)

    }






   val lastData=     dataDb?.qouteDao()?.getLastQoute()





    val listData=     dataDb?.qouteDao()?.getAllQoute()?.asFlow()






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
          val apiData=ApiFactory.apiServices.getQuote()

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