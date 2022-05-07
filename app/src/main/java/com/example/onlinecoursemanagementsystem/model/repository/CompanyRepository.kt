package com.example.onlinecoursemanagementsystem.model.repository

import com.example.onlinecoursemanagementsystem.api.RetrofitInstance

class CompanyRepository {

    suspend fun getCompany()= RetrofitInstance.api.getCompanyList()

    suspend fun deleteCompany(id:Long)=RetrofitInstance.api.deleteCompany(id)

}