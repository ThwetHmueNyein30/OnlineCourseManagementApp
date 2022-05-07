package com.example.onlinecoursemanagementsystem.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecoursemanagementsystem.model.repository.CourseRegistrationRepository
import com.example.onlinecoursemanagementsystem.model.request.CourseRegistrationRequest
import com.example.onlinecoursemanagementsystem.model.response.CourseRegistrationResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class CourseRegistrationViewModel(private val courseRegistrationRepository: CourseRegistrationRepository, private val courseRegistrationRequest: CourseRegistrationRequest) : ViewModel(){

    init {
        registerCourse()
    }

    val courseRegistrationResponse: MutableLiveData<Response<CourseRegistrationResponse>> = MutableLiveData()

    private fun registerCourse()=viewModelScope.launch {
        val response=courseRegistrationRepository.registerCourse(courseRegistrationRequest)
        courseRegistrationResponse.postValue(response)
    }

}