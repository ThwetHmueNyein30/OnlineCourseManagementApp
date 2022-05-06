package com.example.onlinecoursemanagementsystem.repository

import com.example.onlinecoursemanagementsystem.api.RetrofitInstance

class CourseRepository {

    suspend fun getCourse()= RetrofitInstance.api.getCourseList()

}