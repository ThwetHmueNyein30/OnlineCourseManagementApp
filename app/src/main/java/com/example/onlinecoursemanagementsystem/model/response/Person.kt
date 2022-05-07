package com.example.onlinecoursemanagementsystem.model.response

data class Person(
    val address: String?,
    val birthDay: String?,
    val companyId: Long?,
    val createdAt: String?,
    val id: Long,
    val imageUrl: String?,
    val name: String?,
    val phone: String?,
    val roleId: Long?,
    val status: Boolean?,
    val universityId: Long?
)