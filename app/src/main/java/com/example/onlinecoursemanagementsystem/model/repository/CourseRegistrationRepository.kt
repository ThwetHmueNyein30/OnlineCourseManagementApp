package com.example.onlinecoursemanagementsystem.model.repository

import com.example.onlinecoursemanagementsystem.api.RetrofitInstance
import com.example.onlinecoursemanagementsystem.model.request.CourseRegistrationRequest

class CourseRegistrationRepository {

    suspend fun registerCourse(courseRegistrationRequest: CourseRegistrationRequest) = RetrofitInstance.api.registerCourse(courseRegistrationRequest)
}