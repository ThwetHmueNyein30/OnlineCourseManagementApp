package com.example.onlinecoursemanagementsystem.model.response

import com.example.onlinecoursemanagementsystem.model.request.CourseRegistrationRequest

data class CourseRegistrationResponse(
    val dateTime: String,
    val message: String,
    val result: CourseRegistrationRequest,
    val status: Boolean
)