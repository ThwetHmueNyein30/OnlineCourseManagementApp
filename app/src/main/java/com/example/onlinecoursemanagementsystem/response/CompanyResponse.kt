package com.example.onlinecoursemanagementsystem.response

data class CompanyResponse(
    val dateTime: String,
    val message: String,
    val result: List<Company>,
    val status: Boolean
)