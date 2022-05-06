package com.example.onlinecoursemanagementsystem.repository

import com.example.onlinecoursemanagementsystem.api.RetrofitInstance

class PersonRepository {

    suspend fun getPerson()= RetrofitInstance.api.getPersonList()

}