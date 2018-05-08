package com.ancientlore.aldict

import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.view.View

class WordViewModel : BaseViewModel() {

	val name = ObservableField<String>("")

	val translations = ObservableField<String>("")

	val transcription = ObservableField<String>("")

	val synonym = ObservableField<String>("")

	val synonyms = ObservableField<String>("")

	val note = ObservableField<String>("")

	internal fun getWord(): Word {
		val name = this.name.get()!!
		val translations = this.translations.get()!!
		val transcription = this.transcription.get()!!
		val synonyms = this.synonyms.get()!!
		val note = this.note.get()!!
		return Word(name = name, translations = translations, transcription = transcription, note = note, synonyms = synonyms)
	}

	fun synonymsListVisibility() = if (synonyms.get()!!.isNotEmpty()) View.VISIBLE else View.GONE

	fun onAddSynonymClicked() {
		synonym.get()?.let {
			if(isSynonymNew(it)) addSynonym(it)
		}
	}

	private fun isSynonymNew(candidate: String) = synonyms.get()?.split(", ")?.all { it != candidate } ?: false

	private fun addSynonym(synonym: String) {
		val newSynonyms = StringBuilder(synonyms.get()!!)

		if (newSynonyms.isNotEmpty()) newSynonyms.append(", ")

		newSynonyms.append(synonym)

		synonyms.set(newSynonyms.toString())
	}
}