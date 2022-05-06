package com.example.onlinecoursemanagementsystem.repository

import com.example.onlinecoursemanagementsystem.api.RetrofitInstance

class UniversityRepository {

    suspend fun getUniversity()= RetrofitInstance.api.getUniversityList()

}