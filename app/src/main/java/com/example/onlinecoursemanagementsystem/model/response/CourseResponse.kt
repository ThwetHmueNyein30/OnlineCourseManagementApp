package com.example.onlinecoursemanagementsystem.model.response

data class CourseResponse(
    val dateTime: String,
    val message: String,
    val result: List<Course>,
    val status: Boolean
)