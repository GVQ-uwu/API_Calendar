package com.example.api_calendar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_calendar.databinding.ActivityHomeBinding
import com.example.api_calendar.model.Course
import com.example.api_calendar.ui.adapters.CourseAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Dataset temporal (puedes cambiar luego por datos reales)
        val todayCourses = listOf(
            Course("Cálculo I", "08:00 – 09:30", "Prof. Soto", 6, "B203"),
            Course("Programación", "10:00 – 11:30", "Ing. Pérez", 8, "Lab 2"),
            Course("Base de Datos", "12:00 – 13:30", "Msc. Rojas", 7, "A101")
        )

        // Configurar RecyclerView
        binding.rvToday.layoutManager = LinearLayoutManager(this)
        binding.rvToday.adapter = CourseAdapter(todayCourses)

        // Saludo dinámico (más adelante puedes obtenerlo desde preferencias)
        binding.tvGreeting.text = "Hola, Estudiante 👋"
    }
}
