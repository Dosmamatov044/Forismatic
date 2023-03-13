package com.example.forismatic.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.forismatic.Model

@Dao
interface QouteDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend  fun saveQoute(qoute: Model)


    @Query("SELECT * FROM SQ")
    fun getAllQoute():LiveData<List<Model>>

//    @Update
//    fun updateLastQoute(): Model

   @Query("SELECT * FROM SQ WHERE id == (SELECT MAX(id) FROM SQ)")
 fun getLastQoute():LiveData<Model?>

}