package com.example.onlinecoursemanagementsystem.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecoursemanagementsystem.R
import com.example.onlinecoursemanagementsystem.model.request.CourseRegistrationRequest
import com.example.onlinecoursemanagementsystem.model.response.Course
import kotlinx.android.synthetic.main.item_course.view.*

class CourseAdapter : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = differ.currentList[position]
        val courseRegistrationRequest= CourseRegistrationRequest(course.id, course.fee, 2)
        holder.itemView.apply {
            ivImage.setImageResource(R.drawable.sample_pic)
            tvTitle.text = course.name
            tvDesc.text = course.content

            btnDelete.setOnClickListener {
                onItemClickListener?.let {
                    it(course)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    private val differCallBack = object : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallBack)

    private var onItemClickListener: ((Course) -> Unit)? = null

    private var onRegisterClickListener: ((CourseRegistrationRequest) -> Unit)? = null


    fun setOnRegisterClickListener(listener: (CourseRegistrationRequest) -> Unit) {
        onRegisterClickListener = listener
    }

    fun setOnItemClickListener(listener: (Course) -> Unit) {
        onItemClickListener = listener
    }

}