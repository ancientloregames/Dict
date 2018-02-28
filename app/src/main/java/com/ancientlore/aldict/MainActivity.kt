package com.ancientlore.aldict

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
  companion object {
    val INTENT_NEW_WORD = 101
  }
  private val dbExec : ExecutorService = Executors.newSingleThreadExecutor()

  private lateinit var listAdapter : WordsListAdapter

  override fun onCreate(previousState: Bundle?) {
    super.onCreate(previousState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(findViewById(R.id.toolbar))

    DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)

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

  fun addNewWord(view: View) {
    val intent = Intent(this, NewWordActivity::class.java)
    startActivityForResult(intent, INTENT_NEW_WORD)
  }
}
