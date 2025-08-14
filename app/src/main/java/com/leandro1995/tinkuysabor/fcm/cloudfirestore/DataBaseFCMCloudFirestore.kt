package com.leandro1995.tinkuysabor.fcm.cloudfirestore

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.model.entity.TypeTour

class DataBaseFCMCloudFirestore {
    private val firestore = Firebase.firestore

    fun tourismList(
        tourArrayListSuccess: (tourArrayList: ArrayList<Tour>) -> Unit, errorMessage: () -> Unit
    ) {
        val tourArrayList = arrayListOf<Tour>()

        firestore.collection(TOURISM_LIST).get().addOnSuccessListener { result ->
            result.forEach {
                tourArrayList.add(
                    Tour(
                        phone = dataString(key = PHOTO, data = it.data),
                        title = dataString(key = TITLE, data = it.data),
                        description = dataString(key = DESCRIPTION, data = it.data),
                        timetable = dataString(key = TIMETABLE, data = it.data),
                        latitude = dataDouble(key = LATITUDE, data = it.data),
                        longitude = dataDouble(key = LONGITUDE, data = it.data),
                        address = dataString(key = ADDRESS, data = it.data),
                        email = dataString(key = EMAIL, data = it.data),
                        photo = dataString(key = PHONE, data = it.data),
                        typeTour = TypeTour(id = dataInt(key = TYPE, data = it.data))
                    )
                )
            }

            tourArrayListSuccess(tourArrayList)
        }.addOnFailureListener {
            errorMessage()
        }
    }

    private fun dataString(key: String, data: Map<String?, Any?>) = data[key].toString()
    private fun dataDouble(key: String, data: Map<String?, Any?>) = data[key].toString().toDouble()
    private fun dataInt(key: String, data: Map<String?, Any?>) = data[key].toString().toInt()

    companion object {
        private const val TOURISM_LIST = "TourismList"
        private const val PHOTO = "photo"
        private const val TITLE = "title"
        private const val DESCRIPTION = "description"
        private const val TIMETABLE = "timetable"
        private const val LATITUDE = "latitude"
        private const val LONGITUDE = "longitude"
        private const val ADDRESS = "address"
        private const val EMAIL = "email"
        private const val PHONE = "phone"
        private const val TYPE = "type"
    }
}