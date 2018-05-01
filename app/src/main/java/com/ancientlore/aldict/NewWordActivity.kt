package com.ancientlore.aldict

import android.app.Activity
import android.content.Intent
import android.view.View
import com.ancientlore.aldict.databinding.ActivityNewWordBinding

class NewWordActivity : BaseActivity<ActivityNewWordBinding, WordViewModel>(){

	companion object {
		const val EXTRA_WORD = "word"
	}

	override fun getBindingVariable() = BR.word

	override fun getLayoutId() = R.layout.activity_new_word

	override fun createViewModel() = WordViewModel(Word())

	fun submitNewWord(view: View) {
		val activityResult = Intent()
		activityResult.putExtra(EXTRA_WORD, viewModel.getWord())
		setResult(Activity.RESULT_OK, activityResult)
		finish()
	}
}