package com.ancientlore.aldict

import android.support.multidex.MultiDexApplication
import okhttp3.OkHttpClient

class App : MultiDexApplication() {

	companion object {
		lateinit var db : WordsDatabase
		lateinit var okHttpClient: OkHttpClient
	}

	override fun onCreate() {
		super.onCreate()

		db = WordsDatabase.getInstance(this)
		okHttpClient = OkHttpClient()
	}
}