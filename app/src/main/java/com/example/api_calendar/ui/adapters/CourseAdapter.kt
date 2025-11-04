package com.example.api_calendar.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_calendar.databinding.ItemCourseBinding
import com.example.api_calendar.model.Course

class CourseAdapter(private val items: List<Course>) :
    RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vb = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(vb)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = items[position]
        holder.binding.apply {
            tvName.text = course.name
            tvTime.text = course.time
            tvTeacher.text = "Profesor: ${course.teacher}"
            tvExtra.text = "Créditos: ${course.credits} • Sala: ${course.room}"
        }
    }

    override fun getItemCount() = items.size
}
