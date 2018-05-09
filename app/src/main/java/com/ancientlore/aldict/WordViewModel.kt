package com.ancientlore.aldict

import android.databinding.ObservableField
import android.text.Editable
import java.util.concurrent.Executors
import java.util.concurrent.Future

class WordViewModel : BaseViewModel() {

	val name = ObservableField<String>("")

	val translations = ObservableField<String>("")

	val transcription = ObservableField<String>("")

	val synonym = ObservableField<String>("")

	val synonyms = ObservableField<String>("")

	val note = ObservableField<String>("")

	val textWatcher = object : SimpleTextWatcher() {

		private val exec = Executors.newSingleThreadExecutor()
		private var execService: Future<*>? = null

		private val setTranslation = object : Runnable1<String> {
			override fun run(translation: String) {
				translations.set(translation)
			}
		}

		private val printError = object : Runnable1<Throwable> {
			override fun run(throwable: Throwable) {
				throwable.printStackTrace()
			}
		}

		override fun afterTextChanged(s: Editable) {
			if (s.length > 2) {
				execService?.cancel(true)
				execService = exec.submit {
					Utils.getTranslation(s.toString(), setTranslation, printError)
				}
			}
		}
	}

	internal fun getWord(): Word {
		val name = this.name.get()!!
		val translations = this.translations.get()!!
		val transcription = this.transcription.get()!!
		val synonyms = this.synonyms.get()!!
		val note = this.note.get()!!
		return Word(name = name, translations = translations, transcription = transcription, note = note, synonyms = synonyms)
	}

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