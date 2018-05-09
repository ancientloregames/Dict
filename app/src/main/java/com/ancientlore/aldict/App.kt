package com.ancientlore.aldict

import android.support.multidex.MultiDexApplication
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class App : MultiDexApplication() {

	companion object {
		lateinit var requestQueue : RequestQueue
		lateinit var db : WordsDatabase
	}

	override fun onCreate() {
		super.onCreate()

		db = WordsDatabase.getInstance(this)
		requestQueue = Volley.newRequestQueue(this)
	}
}