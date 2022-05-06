package com.example.onlinecoursemanagementsystem.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.onlinecoursemanagementsystem.repository.CompanyRepository
import com.example.onlinecoursemanagementsystem.repository.PersonRepository

class PersonViewModelProviderFactory(private val personRepository: PersonRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonViewModel(personRepository) as T
    }
}