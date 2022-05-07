package com.example.onlinecoursemanagementsystem.ui.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecoursemanagementsystem.model.repository.CompanyRepository
import com.example.onlinecoursemanagementsystem.model.response.CompanyResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class CompanyViewModel(private val companyRepository: CompanyRepository) : ViewModel() {
    init {
        getCompanyList()
    }

    val companyLiveData: MutableLiveData<Response<CompanyResponse>> = MutableLiveData()

    private fun getCompanyList() = viewModelScope.launch {
        val response = companyRepository.getCompany()
        companyLiveData.postValue(response)
    }

    fun deleteCompany(id:Long)=viewModelScope.launch {
      val response = companyRepository.deleteCompany(id)
        Log.d("THN", "deleteCompany: $response")
    }

}