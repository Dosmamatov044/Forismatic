package com.example.forismatic

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SQ")
data class Model(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val quoteAuthor: String?,
    val quoteText: String

)