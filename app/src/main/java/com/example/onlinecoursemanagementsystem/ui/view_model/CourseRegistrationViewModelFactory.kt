package com.example.onlinecoursemanagementsystem.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.onlinecoursemanagementsystem.model.repository.CourseRegistrationRepository
import com.example.onlinecoursemanagementsystem.model.request.CourseRegistrationRequest

class CourseRegistrationViewModelFactory(private val courseRegistrationRepository: CourseRegistrationRepository,private val courseRegistrationRequest: CourseRegistrationRequest): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CourseRegistrationViewModel(courseRegistrationRepository,courseRegistrationRequest) as T
    }
}