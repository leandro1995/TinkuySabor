package com.leandro1995.tinkuysabor.util

import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.model.design.Message

class MessageUtil {

    companion object {
        fun message(message: Message) {
            MaterialAlertDialogBuilder(message.context).apply {
                setTitle(context.getString(R.string.app_name))
                setMessage(message.description())
                setPositiveButton(context.getString(R.string.accept_button)) { dialog, _ ->
                    dialog.dismiss()
                }
            }.show()
        }
    }
}