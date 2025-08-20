package com.leandro1995.tinkuysabor.util

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.model.design.Message

class MessageUtil {

    companion object {
        fun message(context: Context, message: Message) {
            MaterialAlertDialogBuilder(context).apply {
                setTitle(context.getString(R.string.app_name))
                setMessage(message.description(context = context))
                setPositiveButton(context.getString(R.string.accept_button)) { dialog, _ ->
                    dialog.dismiss()
                }
            }.show()
        }
    }
}