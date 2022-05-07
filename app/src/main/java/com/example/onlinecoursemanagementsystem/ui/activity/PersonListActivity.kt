package com.example.onlinecoursemanagementsystem.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinecoursemanagementsystem.R
import com.example.onlinecoursemanagementsystem.adapters.PersonAdapter
import com.example.onlinecoursemanagementsystem.model.repository.PersonRepository
import com.example.onlinecoursemanagementsystem.model.response.Person
import com.example.onlinecoursemanagementsystem.ui.view_model.PersonViewModel
import com.example.onlinecoursemanagementsystem.ui.view_model.PersonViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_person_list.*

class PersonListActivity : AppCompatActivity() {
    private lateinit var personAdapter: PersonAdapter
    lateinit var personViewModel: PersonViewModel
    private val personRepository = PersonRepository()
    private lateinit var personList: ArrayList<Person>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)

        supportActionBar?.title = "Person"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val personViewModelProviderFactory = PersonViewModelProviderFactory(personRepository)
        personViewModel =
            ViewModelProvider(this, personViewModelProviderFactory)[PersonViewModel::class.java]

        setupRecyclerView()
        setupData()

    }

    private fun setupData() {

        personViewModel.personLiveData.observe(this, { response ->
            personAdapter.differ.submitList(response.body()?.result)
        })

        personAdapter.setOnItemClickListener {
            personViewModel.deletePerson(it.id)
        }
    }

    private fun setupRecyclerView() {
        personAdapter = PersonAdapter()
        rvPerson.apply {
            adapter = personAdapter
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