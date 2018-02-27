package com.ancientlore.aldict

import android.arch.persistence.room.TypeConverter
import com.jsoniter.JsonIterator
import com.jsoniter.output.JsonStream
import com.jsoniter.spi.TypeLiteral

class DataConverters {
  @TypeConverter
  fun deserializeToStrList(str: String): List<String> {
    return JsonIterator.deserialize(str, object : TypeLiteral<List<String>>() {

    })
  }

  @TypeConverter
  fun serializeStrList(list: List<String>): String {
    return JsonStream.serialize(list)
  }
}