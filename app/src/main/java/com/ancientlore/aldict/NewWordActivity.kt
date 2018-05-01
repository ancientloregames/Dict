package com.ancientlore.aldict

import com.ancientlore.aldict.databinding.ActivityNewWordBinding

class NewWordActivity : BaseActivity<ActivityNewWordBinding, WordViewModel>(){

	override fun getBindingVariable() = BR.viewModel

	override fun getLayoutId() = R.layout.activity_new_word

	override fun createViewModel() = WordViewModel(Word())
}