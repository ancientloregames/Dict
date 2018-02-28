package com.ancientlore.aldict

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
  private val dbExec : ExecutorService = Executors.newSingleThreadExecutor()

  private lateinit var listAdapter : WordsListAdapter

  override fun onCreate(previousState: Bundle?) {
    super.onCreate(previousState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(findViewById(R.id.toolbar))

    val listView : RecyclerView = findViewById(R.id.listView)

    listView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    dbExec.submit {
      listAdapter = WordsListAdapter(applicationContext.db.wordDao().getAll())
      listView.adapter = listAdapter
    }
  }

  override fun getApplicationContext(): App {
    return super.getApplicationContext() as App
  }
}
