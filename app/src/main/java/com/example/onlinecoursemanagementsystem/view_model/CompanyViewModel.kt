package com.example.onlinecoursemanagementsystem.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinecoursemanagementsystem.repository.CompanyRepository
import com.example.onlinecoursemanagementsystem.response.CompanyResponse
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

}