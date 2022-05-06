package com.example.onlinecoursemanagementsystem.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecoursemanagementsystem.repository.CompanyRepository
import com.example.onlinecoursemanagementsystem.repository.PersonRepository
import com.example.onlinecoursemanagementsystem.response.CompanyResponse
import com.example.onlinecoursemanagementsystem.response.PersonResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class PersonViewModel(private val personRepository:PersonRepository) : ViewModel() {
    init {
        getPersonList()
    }

    val personLiveData: MutableLiveData<Response<PersonResponse>> = MutableLiveData()

    private fun getPersonList() = viewModelScope.launch {
        val response = personRepository.getPerson()
        personLiveData.postValue(response)
    }

}