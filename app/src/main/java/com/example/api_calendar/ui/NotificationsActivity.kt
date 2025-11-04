package com.example.api_calendar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_calendar.databinding.ActivityNotificationsBinding
import com.example.api_calendar.model.AcademicEvent
import com.example.api_calendar.ui.adapters.EventAdapter

class NotificationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Dataset de ejemplo
        val events = listOf(
            AcademicEvent("Examen de Cálculo I", "Viernes 08:30", "Unidad 2"),
            AcademicEvent("Entrega Proyecto BD", "Lunes 23:59", "Subir a Aula Virtual"),
            AcademicEvent("Reunión con Docente", "Miércoles 10:00", "Sala de profesores"),
            AcademicEvent("Evaluación de Inglés", "Martes 09:00", "Tema: Reading & Speaking")
        )

        // RecyclerView
        binding.rvEvents.layoutManager = LinearLayoutManager(this)
        binding.rvEvents.adapter = EventAdapter(events)
    }
}
