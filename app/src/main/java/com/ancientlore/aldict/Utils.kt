package com.ancientlore.aldict

import android.net.Uri
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

object Utils {

	fun getTranslation(text: String, onSuccess: Runnable1<String>, onFailure: Runnable1<Throwable>?) {
		val url = Utils.getTranslateUrl(text, Consts.LANG_EN, Consts.LANG_RU)
		val request = okhttp3.Request.Builder().url(url).build()

		App.okHttpClient.newCall(request).enqueue(object : Callback {
			@Throws(IOException::class)
			override fun onResponse(call: Call, response: Response) {
				if (response.isSuccessful)
					response.body()?.let { onSuccess.run(it.string()) } ?: onFailure?.run(IOException("Empty body"))
				else onFailure?.run(IOException("Failed to download: $url"))
			}
			override fun onFailure(call: Call, e: IOException) {
				onFailure?.run(e)
			}
		})
	}

	private fun getTranslateUrl(text: String, sourceLang: String, targetLang: String): String {
		val url = StringBuilder("https://translate.googleapis.com/translate_a/single?client=gtx&sl=")
		url.append(sourceLang)
		url.append("&tl=")
		url.append(targetLang)
		url.append("&dt=t&q=")
		url.append(Uri.encode(text))
		return url.toString()
	}
}