package com.example.onlinecoursemanagementsystem.model.repository

import com.example.onlinecoursemanagementsystem.api.RetrofitInstance

class PersonRepository {

    suspend fun getPerson()= RetrofitInstance.api.getPersonList()

    suspend fun deletePerson(id:Long)=RetrofitInstance.api.deletePerson(id)


}