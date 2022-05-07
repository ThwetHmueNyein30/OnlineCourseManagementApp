package com.example.onlinecoursemanagementsystem.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecoursemanagementsystem.R

import com.example.onlinecoursemanagementsystem.model.response.Company
import kotlinx.android.synthetic.main.item_company.view.*


class CompanyAdapter: RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        return CompanyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_company,parent,false))
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
       val company=differ.currentList[position]
        holder.itemView.apply {
            ivImage.setImageResource(R.drawable.sample_pic)
            tvTitle.text=company.name
            tvDesc.text=company.address
            btnDelete.setOnClickListener {
                Log.d("THN", "onBindViewHolder: ")

                onItemClickListener?.let{
                    it(company)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    inner class CompanyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){}

    private val differCallBack =object :DiffUtil.ItemCallback<Company>(){
        override fun areItemsTheSame(oldItem: Company, newItem: Company): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Company, newItem: Company): Boolean {
           return oldItem==newItem
        }

    }

    val differ=AsyncListDiffer(this,differCallBack)

    private var onItemClickListener: ((Company)-> Unit)?=null


    fun setOnItemClickListener(listener: (Company)-> Unit){
        onItemClickListener=listener
    }
}