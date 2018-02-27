package com.ancientlore.aldict

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

/**
 * com.ancientlore.aldict. Created by nimblemind on 2/25/2018.
 */

@Database(entities = arrayOf(Word::class), version = 1)
@TypeConverters(DataConverters::class)
abstract class WordsDatabase : RoomDatabase() {

  abstract fun wordDao(): WordDao

  companion object : SingletonHolder<WordsDatabase, Context>({
    Room.databaseBuilder(it.applicationContext,
        WordsDatabase::class.java, "words.db")
        .build()
  })
}