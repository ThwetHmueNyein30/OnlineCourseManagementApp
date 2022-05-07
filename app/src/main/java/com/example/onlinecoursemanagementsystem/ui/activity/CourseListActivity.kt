package com.example.onlinecoursemanagementsystem.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinecoursemanagementsystem.model.response.Course
import com.example.onlinecoursemanagementsystem.R
import com.example.onlinecoursemanagementsystem.adapters.CourseAdapter
import com.example.onlinecoursemanagementsystem.model.repository.CourseRegistrationRepository
import com.example.onlinecoursemanagementsystem.model.repository.CourseRepository
import com.example.onlinecoursemanagementsystem.model.request.CourseRegistrationRequest
import com.example.onlinecoursemanagementsystem.ui.view_model.CourseRegistrationViewModel
import com.example.onlinecoursemanagementsystem.ui.view_model.CourseRegistrationViewModelFactory
import com.example.onlinecoursemanagementsystem.ui.view_model.CourseViewModel
import com.example.onlinecoursemanagementsystem.ui.view_model.CourseViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_course_list.*

class CourseListActivity : AppCompatActivity() {
    private lateinit var courseAdapter: CourseAdapter
    lateinit var courseViewModel: CourseViewModel
    private val courseRepository = CourseRepository()
    private lateinit var courseList: ArrayList<Course>
    lateinit var courseRegistrationViewModel:CourseRegistrationViewModel
    private val courseRegistrationRepository=CourseRegistrationRepository()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_list)

        supportActionBar?.title="Course"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val courseViewModelProviderFactory = CourseViewModelProviderFactory(courseRepository)
        courseViewModel =
            ViewModelProvider(this, courseViewModelProviderFactory)[CourseViewModel::class.java]

        setupRecyclerView()
        setupData()


        courseAdapter.setOnRegisterClickListener {
            val courseRegistration=CourseRegistrationRequest(it.courseId,20.0,1721)
            val courseRegistrationViewModelFactory = CourseRegistrationViewModelFactory(courseRegistrationRepository,courseRegistration)
            courseRegistrationViewModel =
                ViewModelProvider(this, courseRegistrationViewModelFactory)[CourseRegistrationViewModel::class.java]
            courseRegistrationViewModel.courseRegistrationResponse.observe(this,{
                response ->
                Toast.makeText(this,"Successfully registered course!!", Toast.LENGTH_SHORT).show()
            })

        }



    }

    private fun setupData() {
        courseViewModel.courseLiveData.observe(this, { response ->
            courseAdapter.differ.submitList(response.body()?.result)
        })

        courseAdapter.setOnItemClickListener {
            courseViewModel.deleteCourse(it.id)
        }
    }

    private fun setupRecyclerView() {
        courseAdapter = CourseAdapter()
        rvCourse.apply {
            adapter = courseAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->
                finish()

        }
        return super.onOptionsItemSelected(item)
    }
}