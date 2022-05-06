package com.example.onlinecoursemanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.onlinecoursemanagementsystem.repository.CompanyRepository
import com.example.onlinecoursemanagementsystem.repository.CourseRepository
import com.example.onlinecoursemanagementsystem.repository.PersonRepository
import com.example.onlinecoursemanagementsystem.repository.UniversityRepository
import com.example.onlinecoursemanagementsystem.view_model.*
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent




class MainActivity : AppCompatActivity() {

    private val TAG="THN"
    lateinit var companyViewModel: CompanyViewModel
    lateinit var personViewModel: PersonViewModel
    lateinit var universityViewModel: UniversityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()


        btn_person.setOnClickListener {
            personViewModel.personLiveData.observe(this, { response ->
                Log.d(TAG, "PersonList...${response.body()}")
            })
        }

        btn_company.setOnClickListener {
           companyViewModel.companyLiveData.observe(this, { response ->
               Log.d(TAG, "CompanyList...${response.body()}")
           })
        }

        btn_course.setOnClickListener {
            val intent = Intent(this, CourseListActivity::class.java)
            startActivity(intent)
        }

        btn_university.setOnClickListener {
            universityViewModel.universityLiveData.observe(this, { response ->
                Log.d(TAG, "UniversityList...${response.body()}")
            })
        }

    }

    private fun init(){
        val companyRepository=CompanyRepository()
        val personRepository=PersonRepository()
        val universityRepository=UniversityRepository()

        val companyViewModelProviderFactory=CompanyViewModelProviderFactory(companyRepository)
        companyViewModel= ViewModelProvider(this,companyViewModelProviderFactory)[CompanyViewModel::class.java]


        val personViewModelProviderFactory=PersonViewModelProviderFactory(personRepository)
        personViewModel= ViewModelProvider(this,personViewModelProviderFactory)[PersonViewModel::class.java]

        val universityViewModelProviderFactory=UniversityViewModelProviderFactory(universityRepository)
        universityViewModel= ViewModelProvider(this,universityViewModelProviderFactory)[UniversityViewModel::class.java]
    }
}