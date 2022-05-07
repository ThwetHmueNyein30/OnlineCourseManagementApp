package com.example.onlinecoursemanagementsystem.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.onlinecoursemanagementsystem.model.repository.CourseRepository

class CourseViewModelProviderFactory(private val courseRepository: CourseRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CourseViewModel(courseRepository) as T
    }
}