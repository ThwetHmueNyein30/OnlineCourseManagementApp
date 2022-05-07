package com.example.onlinecoursemanagementsystem.model.repository

import com.example.onlinecoursemanagementsystem.api.RetrofitInstance

class UniversityRepository {

    suspend fun getUniversity()= RetrofitInstance.api.getUniversityList()

    suspend fun deleteUniversity(id:Long)=RetrofitInstance.api.deleteUniversity(id)


}