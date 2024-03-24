package com.thecodebasecase.io.common

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.thecodebasecase.io.R

object LoadingDialog {
    private var dialog: Dialog? = null

    public fun show(context: Context) {
        dismiss()

        dialog = Dialog(context).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.loading_dialog)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCancelable(false)
            show()
        }
    }

    fun dismiss() {
        dialog?.dismiss()
        dialog = null
    }
}