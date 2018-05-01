package com.ancientlore.aldict

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean

open class BaseViewModel : ViewModel() {
	private val loading = ObservableBoolean(false)
}
