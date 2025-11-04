package com.example.api_calendar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_calendar.databinding.ActivityListBinding
import com.example.api_calendar.model.Course
import com.example.api_calendar.ui.adapters.CourseAdapter

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Dataset de ejemplo (puedes reemplazar por datos de BD o Firebase)
        val allCourses = listOf(
            Course("Cálculo I", "Lunes 08:00 – 09:30", "Prof. Soto", 6, "B203"),
            Course("Programación", "Martes 10:00 – 11:30", "Ing. Pérez", 8, "Lab 2"),
            Course("Base de Datos", "Miércoles 12:00 – 13:30", "Msc. Rojas", 7, "A101"),
            Course("Inglés Técnico", "Jueves 09:00 – 10:30", "Prof. García", 4, "C102"),
            Course("Ingeniería de Software", "Viernes 14:00 – 15:30", "Ing. Lagos", 8, "Lab 3")
        )

        // RecyclerView
        binding.rvAllCourses.layoutManager = LinearLayoutManager(this)
        binding.rvAllCourses.adapter = CourseAdapter(allCourses)
    }
}
