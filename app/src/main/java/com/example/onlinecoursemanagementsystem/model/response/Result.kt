package com.example.onlinecoursemanagementsystem.model.response

data class Result(
    val courseId: Int,
    val createdAt: Any,
    val fee: Double,
    val id: Int,
    val personId: Int
)