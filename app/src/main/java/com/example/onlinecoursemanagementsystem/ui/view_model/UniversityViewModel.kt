package com.example.onlinecoursemanagementsystem.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecoursemanagementsystem.model.repository.UniversityRepository
import com.example.onlinecoursemanagementsystem.model.response.UniversityResponse
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

    fun deleteUniversity(id:Long)=viewModelScope.launch {
        universityRepository.deleteUniversity(id)
    }

}