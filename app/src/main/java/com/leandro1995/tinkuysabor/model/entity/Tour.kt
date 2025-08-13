package com.leandro1995.tinkuysabor.model.entity

class Tour(
    val photo: String = "",
    val title: String = "",
    val description: String = "",
    val timetable: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val address: String = "",
    val email: String = "",
    val phone: String = "",
    val typeTour: TypeTour = TypeTour()
)