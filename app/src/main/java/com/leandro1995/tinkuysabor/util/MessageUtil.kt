package com.leandro1995.tinkuysabor.util

import android.content.Context
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.extension.visibility
import com.leandro1995.tinkuysabor.model.design.Message

class MessageUtil {

    companion object {
        fun message(context: Context, message: Message, method: () -> Unit = {}) {
            MaterialAlertDialogBuilder(context).apply {
                setTitle(context.getString(R.string.app_name))
                setMessage(message.description(context = context))
                setPositiveButton(context.getString(R.string.accept_button)) { dialog, _ ->
                    dialog.dismiss()
                    method()
                }
            }.show()
        }

        fun bottomSheetBehavior(
            view: View, isVisible: Boolean = true, typeBottomSheetBehavior: Int
        ) {
            view.visibility(isVisible = isVisible)
            BottomSheetBehavior.from(view).apply {
                state = typeBottomSheetBehavior
                addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                            state = BottomSheetBehavior.STATE_COLLAPSED
                        }
                    }

                    override fun onSlide(bottomSheet: View, slideOffset: Float) {

                    }
                })
            }
        }
    }
}