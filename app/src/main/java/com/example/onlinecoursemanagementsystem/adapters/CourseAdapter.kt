package com.example.onlinecoursemanagementsystem.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinecoursemanagementsystem.R
import com.example.onlinecoursemanagementsystem.response.Course
import kotlinx.android.synthetic.main.item_data.view.*
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import android.util.Log
import java.io.File
import java.net.URL


class CourseAdapter: RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false))
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
       val course=differ.currentList[position]
        Log.d("CourseAdapter", "onBindViewHolder: "+ course)
        holder.itemView.apply {
//            val file = File(URL("/Users/mobile-5/Desktop/sample_pic.jpeg").toURI())
//
//            val filePath: String = file.path
//            val bitmap = BitmapFactory.decodeFile(filePath)
//            ivImage.setImageBitmap(bitmap)
            ivImage.setImageResource(R.drawable.sample_pic)
            tvTitle.text=course.name
            tvDesc.text=course.content
            setOnClickListener {
                onItemClickListener?.let{
                    it(course)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    inner class CourseViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){}

    private val differCallBack =object :DiffUtil.ItemCallback<Course>(){
        override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
           return oldItem==newItem
        }

    }

    val differ=AsyncListDiffer(this,differCallBack)

    private var onItemClickListener: ((Course)-> Unit)?=null

    fun setOnItemClickListener(listener: (Course)-> Unit){
        onItemClickListener=listener
    }
}