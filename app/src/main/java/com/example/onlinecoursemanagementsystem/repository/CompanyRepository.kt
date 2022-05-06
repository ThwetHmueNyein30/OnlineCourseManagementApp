package com.example.onlinecoursemanagementsystem.repository

import com.example.onlinecoursemanagementsystem.api.RetrofitInstance

class CompanyRepository {

    suspend fun getCompany()= RetrofitInstance.api.getCompanyList()

}