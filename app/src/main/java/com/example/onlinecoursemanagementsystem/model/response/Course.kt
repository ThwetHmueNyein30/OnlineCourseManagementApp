package com.example.onlinecoursemanagementsystem.model.response

data class Course(
    val content: String,
    val createdAt: String,
    val documentPath: String,
    val fee: Double,
    val id: Long,
    val imageUrl: String,
    val name: String,
    val registeredFrom: String,
    val registeredTo: String,
    val status: Boolean,
    val teacherId: Long
)