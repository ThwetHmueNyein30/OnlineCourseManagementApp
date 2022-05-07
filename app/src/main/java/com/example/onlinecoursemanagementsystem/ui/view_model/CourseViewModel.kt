package com.example.onlinecoursemanagementsystem.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecoursemanagementsystem.model.repository.CourseRepository
import com.example.onlinecoursemanagementsystem.model.response.CourseResponse
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

    fun deleteCourse(id:Long)=viewModelScope.launch {
        courseRepository.deleteCourse(id)
    }

}