package com.example.onlinecoursemanagementsystem.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecoursemanagementsystem.repository.CompanyRepository
import com.example.onlinecoursemanagementsystem.repository.CourseRepository
import com.example.onlinecoursemanagementsystem.response.CompanyResponse
import com.example.onlinecoursemanagementsystem.response.CourseResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class CourseViewModel(private val courseRepository: CourseRepository) : ViewModel() {
    init {
        getCourseList()
    }

    val courseLiveData: MutableLiveData<Response<CourseResponse>> = MutableLiveData()

    private fun getCourseList() = viewModelScope.launch {
        val response = courseRepository.getCourse()
        courseLiveData.postValue(response)
    }

}