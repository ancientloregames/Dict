package com.ancientlore.aldict

import android.net.Uri
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

object Utils {


	fun getTranslation(text: String, onSuccess: Runnable1<String>, onError: Runnable1<Throwable>?) {
		val url = Utils.getTranslateUrl(text, Consts.LANG_EN, Consts.LANG_RU)
		val request = StringRequest(Request.Method.GET, url,
				Response.Listener<String> { response ->
					onSuccess.run(response)
				},
				Response.ErrorListener {
					onError?.run(it)
				})

		App.requestQueue.add(request)
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