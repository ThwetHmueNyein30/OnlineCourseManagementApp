package com.example.onlinecoursemanagementsystem.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecoursemanagementsystem.model.repository.PersonRepository
import com.example.onlinecoursemanagementsystem.model.response.PersonResponse
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

    fun deletePerson(id:Long)=viewModelScope.launch {
        personRepository.deletePerson(id)
    }

}