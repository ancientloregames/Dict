package com.ancientlore.aldict

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

/**
 * com.ancientlore.aldict. Created by nimblemind on 2/25/2018.
 */

@Entity(tableName = "words", indices = [(Index(value = "name", unique = true))])
data class Word(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                @field:ColumnInfo(name = "name") var name: String = "",
                @field:ColumnInfo(name = "transcription") var transcription: String = "",
                @field:ColumnInfo(name = "note") var note: String = "",
                @field:ColumnInfo(name = "translations") var translations: String = "",
                @field:ColumnInfo(name = "synonyms") var synonyms: String = "",
                @field:ColumnInfo(name = "topics") var topics: String = "",
                @field:ColumnInfo(name = "imagePath") var imagePath: String = "",
                @field:ColumnInfo(name = "audioPath") var audioPath: String = "") : Parcelable {

	private constructor(parcel: Parcel) : this(
			id = parcel.readValue(Long::class.java.classLoader) as Long,
			name = parcel.readString(),
			transcription = parcel.readString(),
			note = parcel.readString(),
			translations = parcel.readString(),
			synonyms = parcel.readString(),
			topics = parcel.readString(),
			imagePath = parcel.readString(),
			audioPath = parcel.readString())

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(id)
		parcel.writeString(name)
		parcel.writeString(transcription)
		parcel.writeString(note)
		parcel.writeString(translations)
		parcel.writeString(synonyms)
		parcel.writeString(topics)
		parcel.writeString(imagePath)
		parcel.writeString(audioPath)
	}

	override fun describeContents() = 0

	companion object {
		@JvmField
		val CREATOR = object : Parcelable.Creator<Word> {
			override fun createFromParcel(parcel: Parcel) = Word(parcel)

			override fun newArray(size: Int) = arrayOfNulls<Word>(size)
		}
	}
}
