package com.ancientlore.aldict

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {
	private lateinit var viewDataBinding : T
	protected lateinit var viewModel : V

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setSupportActionBar(findViewById(R.id.toolbar))

		viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
		viewModel = createViewModel()
		viewDataBinding.setVariable(getBindingVariable(), viewModel)
		viewDataBinding.executePendingBindings()
	}

	@LayoutRes
	abstract fun getLayoutId() : Int

	abstract fun getBindingVariable() : Int

	abstract fun createViewModel() : V
}