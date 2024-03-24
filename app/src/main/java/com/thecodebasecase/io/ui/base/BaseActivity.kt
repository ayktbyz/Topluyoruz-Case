package com.thecodebasecase.io.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thecodebasecase.io.common.LoadingDialog

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

     fun showLoading(show: Boolean) {
        if (show) {
            LoadingDialog.show(this)
        } else {
            LoadingDialog.dismiss()
        }
    }
}