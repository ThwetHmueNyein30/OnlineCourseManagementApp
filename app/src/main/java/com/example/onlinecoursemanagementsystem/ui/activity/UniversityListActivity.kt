package com.example.onlinecoursemanagementsystem.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinecoursemanagementsystem.R
import com.example.onlinecoursemanagementsystem.adapters.UniversityAdapter
import com.example.onlinecoursemanagementsystem.model.repository.UniversityRepository
import com.example.onlinecoursemanagementsystem.model.response.University
import com.example.onlinecoursemanagementsystem.ui.view_model.UniversityViewModel
import com.example.onlinecoursemanagementsystem.ui.view_model.UniversityViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_university_list.*

class UniversityListActivity : AppCompatActivity() {
    private lateinit var universityAdapter: UniversityAdapter
    lateinit var universityViewModel: UniversityViewModel
    private val universityRepository = UniversityRepository()
    private lateinit var universityList: ArrayList<University>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university_list)

        supportActionBar?.title="University"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val universityViewModelProviderFactory = UniversityViewModelProviderFactory(universityRepository)
        universityViewModel =
            ViewModelProvider(this, universityViewModelProviderFactory)[UniversityViewModel::class.java]

        setupRecyclerView()
        setupData()

    }

    private fun setupData() {
        universityViewModel.universityLiveData.observe(this, { response ->
            universityAdapter.differ.submitList(response.body()?.result)
        })

        universityAdapter.setOnItemClickListener {
            universityViewModel.deleteUniversity(it.id)
        }
    }

    private fun setupRecyclerView() {
        universityAdapter = UniversityAdapter()
        rvUniversity.apply {
            adapter = universityAdapter
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