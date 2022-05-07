package com.example.onlinecoursemanagementsystem.model.request

data class CourseRegistrationRequest(
    val courseId: Long,
    val fee: Double,
    val studentId: Long
)