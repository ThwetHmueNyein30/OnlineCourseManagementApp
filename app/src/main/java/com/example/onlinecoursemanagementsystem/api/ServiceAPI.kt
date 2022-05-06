package com.example.onlinecoursemanagementsystem.api

import com.example.onlinecoursemanagementsystem.response.CompanyResponse
import com.example.onlinecoursemanagementsystem.response.CourseResponse
import com.example.onlinecoursemanagementsystem.response.PersonResponse
import com.example.onlinecoursemanagementsystem.response.UniversityResponse
import retrofit2.Response
import retrofit2.http.GET

interface ServiceAPI {

    @GET("/course")
    suspend fun getCourseList(): Response<CourseResponse>

    @GET("/company")
    suspend fun getCompanyList() : Response<CompanyResponse>

    @GET("/person")
    suspend fun getPersonList(): Response<PersonResponse>

    @GET("/university")
    suspend fun getUniversityList(): Response<UniversityResponse>
}