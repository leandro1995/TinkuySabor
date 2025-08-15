package com.leandro1995.tinkuysabor.model.entity

import com.leandro1995.tinkuysabor.fcm.cloudfirestore.DataBaseFCMCloudFirestore

class User(
    var giveName: String = "",
    var familyName: String = "",
    var email: String = "",
    var picture: String = ""
) {

    fun tourismList(
        tourArrayListSuccess: (tourArrayList: ArrayList<Tour>) -> Unit, errorMessage: () -> Unit
    ) {
        DataBaseFCMCloudFirestore().tourismList(
            tourArrayListSuccess = tourArrayListSuccess, errorMessage = errorMessage
        )
    }
}