package com.ancientlore.aldict

import android.databinding.ObservableField

class WordViewModel : BaseViewModel() {

	val name = ObservableField<String>("")

	val translations = ObservableField<String>("")

	val transcription = ObservableField<String>("")

	internal fun getWord(): Word {
		val name = this.name.get()!!
		val translations = this.translations.get()!!
		val transcription = this.transcription.get()!!
		return Word(name = name, translations = translations, transcription = transcription)
	}
}