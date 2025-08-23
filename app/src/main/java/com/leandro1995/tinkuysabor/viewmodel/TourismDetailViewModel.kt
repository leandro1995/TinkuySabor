package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class TourismDetailViewModel : ViewModelAmbient<Any, Any>() {

    var tour: Tour? = null
}