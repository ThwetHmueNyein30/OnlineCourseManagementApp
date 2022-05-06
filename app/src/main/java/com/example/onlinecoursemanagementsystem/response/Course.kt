package com.example.onlinecoursemanagementsystem.response

data class Course(
    val content: String,
    val createdAt: String,
    val documentPath: String,
    val fee: Double,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val registeredFrom: String,
    val registeredTo: String,
    val status: Any,
    val teacherId: Int
)