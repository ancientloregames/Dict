package com.ancientlore.aldict

class WordViewModel(private val word: Word) : BaseViewModel() {

	fun getWord() = word.name

	fun getTranslations() = word.translations?.joinToString() ?: ""

	fun getTranscription() = word.transcription
}