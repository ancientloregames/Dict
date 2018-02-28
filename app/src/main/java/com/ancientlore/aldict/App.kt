package com.ancientlore.aldict

import android.app.Application

class App : Application() {

  lateinit var db : WordsDatabase

  override fun onCreate() {
    super.onCreate()

    db = WordsDatabase.getInstance(this)
  }
}