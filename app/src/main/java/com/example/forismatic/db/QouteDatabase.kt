package com.example.forismatic.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.forismatic.Model

@Database(entities = [Model::class], version = 1)
abstract class QouteDatabase: RoomDatabase() {
    companion object {

        private var db: QouteDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): QouteDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        QouteDatabase::class.java,
                        DB_NAME
                    ).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun qouteDao(): QouteDao
}
