package com.example.onlinecoursemanagementsystem.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.onlinecoursemanagementsystem.model.repository.CompanyRepository

class CompanyViewModelProviderFactory(private val companyRepository: CompanyRepository) : ViewModelProvider.Factory {



    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CompanyViewModel(companyRepository) as T
    }
}