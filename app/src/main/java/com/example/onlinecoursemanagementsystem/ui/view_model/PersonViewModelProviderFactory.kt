package com.example.onlinecoursemanagementsystem.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.onlinecoursemanagementsystem.model.repository.PersonRepository

class PersonViewModelProviderFactory(private val personRepository: PersonRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonViewModel(personRepository) as T
    }
}