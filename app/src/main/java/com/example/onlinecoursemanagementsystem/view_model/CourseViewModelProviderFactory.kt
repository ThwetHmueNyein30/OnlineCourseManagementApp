package com.example.onlinecoursemanagementsystem.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.onlinecoursemanagementsystem.repository.CompanyRepository
import com.example.onlinecoursemanagementsystem.repository.CourseRepository

class CourseViewModelProviderFactory(private val courseRepository: CourseRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CourseViewModel(courseRepository) as T
    }
}