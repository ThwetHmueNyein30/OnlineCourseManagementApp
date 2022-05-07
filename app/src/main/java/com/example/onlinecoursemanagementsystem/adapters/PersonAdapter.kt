package com.example.onlinecoursemanagementsystem.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecoursemanagementsystem.R
import com.example.onlinecoursemanagementsystem.model.response.Person
import kotlinx.android.synthetic.main.item_person.view.*


class PersonAdapter: RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person,parent,false))
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
       val person=differ.currentList[position]
        holder.itemView.apply {
            ivImage.setImageResource(R.drawable.sample_pic)
            tvTitle.text=person.name
            tvDesc.text=person.address
            setOnClickListener {
                onItemClickListener?.let{
                    it(person)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    inner class PersonViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){}

    private val differCallBack =object :DiffUtil.ItemCallback<Person>(){
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
           return oldItem==newItem
        }

    }

    val differ=AsyncListDiffer(this,differCallBack)

    private var onItemClickListener: ((Person)-> Unit)?=null

    fun setOnItemClickListener(listener: (Person)-> Unit){
        onItemClickListener=listener
    }
}