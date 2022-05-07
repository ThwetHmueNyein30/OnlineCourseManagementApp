package com.example.onlinecoursemanagementsystem.ui.activity

import android.app.ProgressDialog.show
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecoursemanagementsystem.R
import com.example.onlinecoursemanagementsystem.adapters.CompanyAdapter
import com.example.onlinecoursemanagementsystem.model.repository.CompanyRepository
import com.example.onlinecoursemanagementsystem.model.response.Company
import com.example.onlinecoursemanagementsystem.ui.view_model.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_company_list.*

class CompanyListActivity : AppCompatActivity() {
    private lateinit var companyAdapter: CompanyAdapter
    lateinit var companyViewModel: CompanyViewModel
    private val companyRepository= CompanyRepository()
    private lateinit var companyList: ArrayList<Company>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_list)

        supportActionBar?.title = "Company"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val companyViewModelProviderFactory = CompanyViewModelProviderFactory(companyRepository)
        companyViewModel =
            ViewModelProvider(this, companyViewModelProviderFactory)[CompanyViewModel::class.java]

        setupRecyclerView()
        setupData()

    }

    private fun setupData() {
        companyViewModel.companyLiveData.observe(this, { response ->
            companyAdapter.differ.submitList(response.body()?.result)
        })

        companyAdapter.setOnItemClickListener {
            companyViewModel.deleteCompany(it.id)
        }
    }

    private fun setupRecyclerView() {
        companyAdapter = CompanyAdapter()
        rvCompany.apply {
            adapter = companyAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->
                finish()

        }
        return super.onOptionsItemSelected(item)
    }
}