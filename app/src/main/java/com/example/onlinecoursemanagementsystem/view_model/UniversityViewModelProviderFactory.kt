package com.example.onlinecoursemanagementsystem.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.onlinecoursemanagementsystem.repository.CompanyRepository
import com.example.onlinecoursemanagementsystem.repository.UniversityRepository

class UniversityViewModelProviderFactory(private val universityRepository: UniversityRepository) : ViewModelProvider.Factory {



    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UniversityViewModel(universityRepository) as T
    }
}