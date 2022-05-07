package com.example.onlinecoursemanagementsystem.api

import com.example.onlinecoursemanagementsystem.model.request.CourseRegistrationRequest
import com.example.onlinecoursemanagementsystem.model.response.*
import retrofit2.Response
import retrofit2.http.*

interface ServiceAPI {

    @GET("course")
    suspend fun getCourseList(): Response<CourseResponse>

    @DELETE("course/{id}")
    suspend fun deleteCourse(@Path("id") id:Long): Response<CourseResponse>

    @PUT("course/{id}")
    suspend fun updateCourse(@Path("id") id:Long, course:Course):Response<CourseResponse>

    @POST("course")
    suspend fun createCourse(@Body course: Course): Response<CourseResponse>


    @GET("company")
    suspend fun getCompanyList() : Response<CompanyResponse>

    @DELETE("company/{id}")
    suspend fun deleteCompany(@Path("id") id:Long): Response<CompanyResponse>

    @PUT("company/{id}")
    suspend fun updateCompany(@Path("id") id:Long, company:Company):Response<CompanyResponse>

    @POST("company")
    suspend fun createCompany(@Body company:Company): Response<CompanyResponse>


    @GET("person")
    suspend fun getPersonList(): Response<PersonResponse>

    @DELETE("person/{id}")
    suspend fun deletePerson(@Path("id") id:Long): Response<PersonResponse>

    @PUT("person/{id}")
    suspend fun updatePerson(@Path("id") id:Long, person: Person):Response<PersonResponse>

    @POST("person")
    suspend fun createPerson(@Body person: Person): Response<PersonResponse>

    @GET("university")
    suspend fun getUniversityList(): Response<UniversityResponse>

    @DELETE("university/{id}")
    suspend fun deleteUniversity(@Path("id") id:Long): Response<UniversityResponse>

    @PUT("university/{id}")
    suspend fun updateUniversity(@Path("id") id:Long, university: University):Response<UniversityResponse>

    @POST("university")
    suspend fun createUniversity(@Body university: University): Response<UniversityResponse>


    @POST("courseRegistration")
    suspend fun registerCourse(@Body courseRegistrationRequest: CourseRegistrationRequest) : Response<CourseRegistrationResponse>


}