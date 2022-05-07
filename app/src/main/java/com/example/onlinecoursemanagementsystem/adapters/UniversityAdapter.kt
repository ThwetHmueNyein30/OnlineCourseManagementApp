package com.example.onlinecoursemanagementsystem.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecoursemanagementsystem.R
import com.example.onlinecoursemanagementsystem.model.response.University
import kotlinx.android.synthetic.main.item_university.view.*


class UniversityAdapter: RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        return UniversityViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_university,parent,false))
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
       val university=differ.currentList[position]
        holder.itemView.apply {
            ivImage.setImageResource(R.drawable.sample_pic)
            tvTitle.text=university.name
            tvDesc.text=university.content
            setOnClickListener {
                onItemClickListener?.let{
                    it(university)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    inner class UniversityViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){}

    private val differCallBack =object :DiffUtil.ItemCallback<University>(){
        override fun areItemsTheSame(oldItem: University, newItem: University): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: University, newItem: University): Boolean {
           return oldItem==newItem
        }

    }

    val differ=AsyncListDiffer(this,differCallBack)

    private var onItemClickListener: ((University)-> Unit)?=null

    fun setOnItemClickListener(listener: (University)-> Unit){
        onItemClickListener=listener
    }
}