package com.example.api_calendar.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_calendar.databinding.ItemEventBinding
import com.example.api_calendar.model.AcademicEvent

class EventAdapter(private val events: List<AcademicEvent>) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vb = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(vb)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = events[position]
        holder.binding.apply {
            tvTitle.text = event.title
            tvTime.text = event.time
            tvDetail.text = event.detail
        }
    }

    override fun getItemCount(): Int = events.size
}
