package com.example.onlinecoursemanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinecoursemanagementsystem.adapters.CourseAdapter
import com.example.onlinecoursemanagementsystem.repository.CourseRepository
import com.example.onlinecoursemanagementsystem.view_model.CourseViewModel
import com.example.onlinecoursemanagementsystem.view_model.CourseViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_course_list.*

class CourseListActivity : AppCompatActivity() {
    private lateinit var courseAdapter: CourseAdapter
    lateinit var courseViewModel: CourseViewModel
    private val courseRepository= CourseRepository()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_list)

        val courseViewModelProviderFactory= CourseViewModelProviderFactory(courseRepository)
        courseViewModel= ViewModelProvider(this,courseViewModelProviderFactory)[CourseViewModel::class.java]

        setupRecyclerView()
        setupData()

    }

    private fun setupData() {
        courseViewModel.courseLiveData.observe(this, { response ->
            courseAdapter.differ.submitList(response.body()?.result)
        })
    }

    private fun setupRecyclerView() {
        courseAdapter= CourseAdapter()
        rvCourse.apply {
            adapter=courseAdapter
            layoutManager=LinearLayoutManager(context)
        }
    }
}