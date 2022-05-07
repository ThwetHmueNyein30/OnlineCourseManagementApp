package com.example.onlinecoursemanagementsystem.model.response

data class PersonResponse(
    val dateTime: String,
    val message: String,
    val result: List<Person>,
    val status: Boolean
)