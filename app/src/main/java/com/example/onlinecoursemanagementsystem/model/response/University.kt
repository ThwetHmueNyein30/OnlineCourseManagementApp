package com.example.onlinecoursemanagementsystem.model.response

data class University(
    var content: String?,
    var createdAt: String?,
    var documentPath: String?,
    var fee: Double?,
    var id: Long,
    var imageUrl: String?,
    var name: String?,
    var registeredFrom: String?,
    var registeredTo: String?,
    var status: Boolean?,
    var teacherId: Long?
)