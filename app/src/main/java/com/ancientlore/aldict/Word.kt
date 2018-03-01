package com.ancientlore.aldict

import android.arch.persistence.room.*
import android.os.Parcel
import android.os.Parcelable

/**
 * com.ancientlore.aldict. Created by nimblemind on 2/25/2018.
 */

@Entity(tableName = "words", indices = arrayOf(Index(value = "name", unique = true)))
data class Word(@PrimaryKey(autoGenerate = true) var id: Long?,
                @field:ColumnInfo(name = "name") var name: String,
                @field:ColumnInfo(name = "transcription") var transcription: String,
                @field:ColumnInfo(name = "note") var note: String,
                @field:ColumnInfo(name = "translations") var translations: List<String>?,
                @field:ColumnInfo(name = "synonyms") var synonyms: List<String>?,
                @field:ColumnInfo(name = "topics") var topics: List<String>?,
                @field:ColumnInfo(name = "imagePath") var imagePath: String,
                @field:ColumnInfo(name = "audioPath") var audioPath: String) : Parcelable {

  private constructor(parcel: Parcel) : this(
      id = parcel.readValue(Long::class.java.classLoader) as? Long,
      name = parcel.readString(),
      transcription = parcel.readString(),
      note = parcel.readString(),
      translations = parcel.createStringArrayList(),
      synonyms = parcel.createStringArrayList(),
      topics = parcel.createStringArrayList(),
      imagePath = parcel.readString(),
      audioPath = parcel.readString())

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(id)
    parcel.writeString(name)
    parcel.writeString(transcription)
    parcel.writeString(note)
    parcel.writeStringList(translations)
    parcel.writeStringList(synonyms)
    parcel.writeStringList(topics)
    parcel.writeString(imagePath)
    parcel.writeString(audioPath)
  }

  override fun describeContents() = 0

  companion object {
    @JvmField val CREATOR = object : Parcelable.Creator<Word> {
      override fun createFromParcel(parcel: Parcel) = Word(parcel)

      override fun newArray(size: Int) = arrayOfNulls<Word>(size)
    }
  }
}
