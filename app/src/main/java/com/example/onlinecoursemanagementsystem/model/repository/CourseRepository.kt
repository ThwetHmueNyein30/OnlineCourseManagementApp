package com.example.onlinecoursemanagementsystem.model.repository

import com.example.onlinecoursemanagementsystem.api.RetrofitInstance

class CourseRepository {

    suspend fun getCourse()= RetrofitInstance.api.getCourseList()

    suspend fun deleteCourse(id:Long)=RetrofitInstance.api.deleteCourse(id)


}