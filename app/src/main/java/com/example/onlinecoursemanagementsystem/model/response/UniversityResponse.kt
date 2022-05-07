package com.example.onlinecoursemanagementsystem.model.response

data class UniversityResponse(
    val dateTime: String,
    val message: String,
    val result: List<University>,
    val status: Boolean
)