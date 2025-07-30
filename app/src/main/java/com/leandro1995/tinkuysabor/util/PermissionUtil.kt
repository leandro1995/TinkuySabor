package com.leandro1995.tinkuysabor.util

import android.Manifest
import android.os.Build
import androidx.fragment.app.FragmentActivity
import com.leandro1995.tinkuysabor.R
import com.permissionx.guolindev.PermissionX

class PermissionUtil {
    companion object {
        fun messagingPermission(fragmentActivity: FragmentActivity, method: () -> Unit) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                PermissionX.init(fragmentActivity)
                    .permissions(Manifest.permission.POST_NOTIFICATIONS)
                    .onExplainRequestReason { scope, deniedList ->
                        scope.showRequestReasonDialog(
                            deniedList,
                            fragmentActivity.getString(R.string.permission_message),
                            fragmentActivity.getString(R.string.accept_button),
                            fragmentActivity.getString(R.string.cancel_button)
                        )
                    }.onForwardToSettings { scope, deniedList ->
                        scope.showForwardToSettingsDialog(
                            deniedList,
                            fragmentActivity.getString(R.string.permission_config_message),
                            fragmentActivity.getString(R.string.accept_button),
                            fragmentActivity.getString(R.string.cancel_button)
                        )
                    }.request { isAllGranted, grantedList, deniedList ->
                        if (isAllGranted) {
                            method()
                        }
                    }
            } else {
                method()
            }
        }
    }
}