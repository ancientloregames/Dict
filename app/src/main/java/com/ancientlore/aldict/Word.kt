package com.ancientlore.aldict

import android.arch.persistence.room.*

/**
 * com.ancientlore.aldict. Created by nimblemind on 2/25/2018.
 */

@Entity(tableName = "words", indices = arrayOf(Index(value = "name", unique = true)))
data class Word(@PrimaryKey(autoGenerate = true) var id: Long?,
                @field:ColumnInfo(name = "name") var word: String,
                @field:ColumnInfo(name = "transcription") var transcription: String,
                @field:ColumnInfo(name = "note") var note: String,
                @field:ColumnInfo(name = "translations") var translations: List<String>?,
                @field:ColumnInfo(name = "synonyms") var synonyms: List<String>?,
                @field:ColumnInfo(name = "topics") var topics: List<String>?,
                @field:ColumnInfo(name = "imagePath") var imagePath: String,
                @field:ColumnInfo(name = "audioPath") var audioPath: String)
