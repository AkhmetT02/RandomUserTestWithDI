package com.example.randomusertest.models


data class User(
    val cell: String?,
    val dob: Dob?,
    val email: String?,
    val gender: String?,
    val id: Id?,
    val location: Location?,
    val name: Name,
    val nat: String?,
    val phone: String?,
    val picture: Picture?
)