package com.ancientlore.aldict

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * com.ancientlore.aldict. Created by nimblemind on 2/25/2018.
 */

@Database(entities = arrayOf(Word::class), version = 1)
abstract class WordsDatabase : RoomDatabase() {
  abstract fun wordDao(): WordDao

  companion object {
    private var INSTANCE: WordsDatabase? = null

    fun getInstance(context: Context): WordsDatabase? {
      if (INSTANCE == null) {
        synchronized(WordsDatabase::class) {
          INSTANCE = Room.databaseBuilder(context.applicationContext,
               WordsDatabase::class.java, "weather.db")
               .build()
        }
      }
      return INSTANCE
    }

    fun destroyInstance() {
      INSTANCE = null
    }
  }
}