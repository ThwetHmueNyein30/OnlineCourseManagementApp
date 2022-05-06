package com.example.onlinecoursemanagementsystem.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecoursemanagementsystem.repository.CompanyRepository
import com.example.onlinecoursemanagementsystem.repository.UniversityRepository
import com.example.onlinecoursemanagementsystem.response.CompanyResponse
import com.example.onlinecoursemanagementsystem.response.UniversityResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class UniversityViewModel(private val universityRepository: UniversityRepository) : ViewModel() {
    init {
        getUniversityList()
    }

    val universityLiveData: MutableLiveData<Response<UniversityResponse>> = MutableLiveData()

    private fun getUniversityList() = viewModelScope.launch {
        val response = universityRepository.getUniversity()
        universityLiveData.postValue(response)
    }

}