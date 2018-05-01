package com.ancientlore.aldict

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ancientlore.aldict.databinding.ActivityMainBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

	companion object {
		const val INTENT_NEW_WORD = 101
	}

	private val dbExec: ExecutorService = Executors.newSingleThreadExecutor()

	private lateinit var listAdapter: WordsListAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val listView: RecyclerView = findViewById(R.id.listView)

		listView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

		dbExec.submit {
			listAdapter = WordsListAdapter(applicationContext.db.wordDao().getAll())
			listView.adapter = listAdapter
		}
	}

	override fun getLayoutId() = R.layout.activity_main

	override fun getBindingVariable() = BR.viewModel

	override fun createViewModel() = MainViewModel()

	override fun getApplicationContext() = super.getApplicationContext() as App

	fun addNewWord(view: View) {
		val intent = Intent(this, NewWordActivity::class.java)
		startActivityForResult(intent, INTENT_NEW_WORD)
	}
}
