package com.example.nightlife2.model

class User(id: Int, name: String) {
    val id = id
    val name = name
    val favorites = mutableListOf<Int>(1,2,3)
}