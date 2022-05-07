package com.example.onlinecoursemanagementsystem.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.example.onlinecoursemanagementsystem.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()


        btn_person.setOnClickListener {
            val intent = Intent(this, PersonListActivity::class.java)
            startActivity(intent)
        }

        btn_company.setOnClickListener {
            val intent = Intent(this, CompanyListActivity::class.java)
            startActivity(intent)
        }

        btn_course.setOnClickListener {
            val intent = Intent(this, CourseListActivity::class.java)
            startActivity(intent)
        }

        btn_university.setOnClickListener {
            val intent = Intent(this, UniversityListActivity::class.java)
            startActivity(intent)
        }

    }

    private fun init(){

    }
}