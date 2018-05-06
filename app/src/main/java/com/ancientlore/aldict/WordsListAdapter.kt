package com.ancientlore.aldict

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * com.ancientlore.aldict. Created by nimblemind on 2/25/2018.
 */
class WordsListAdapter(private val items : List<Word>) : RecyclerView.Adapter<WordsListAdapter.ViewHolder>() {

  override fun getItemCount(): Int {
    return items.count()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.base_list_item, parent, false))
  }

  override fun onBindViewHolder(holder: ViewHolder, index: Int) {
    holder.bind(items[index])
  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleView: TextView = itemView.findViewById(R.id.title)
    private val subtitleView: TextView = itemView.findViewById(R.id.subtitle)

    fun bind(data: Word) {
      titleView.text = data.name
      subtitleView.text = data.translations?.get(0) ?: ""
    }
  }
}