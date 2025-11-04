package com.example.api_calendar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_calendar.databinding.ActivityCalendarBinding
import com.example.api_calendar.model.AcademicEvent
import com.example.api_calendar.ui.adapters.EventAdapter
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalendarBinding
    private val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Configurar RecyclerView
        binding.rvEventsDay.layoutManager = LinearLayoutManager(this)

        // Fecha inicial (hoy)
        val today = Calendar.getInstance()
        updateEvents(today)

        // Listener del CalendarView
        binding.calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, dayOfMonth)
            updateEvents(selectedDate)
        }
    }

    /** Actualiza la lista de eventos según la fecha seleccionada */
    private fun updateEvents(date: Calendar) {
        val formattedDate = sdf.format(date.time)
        binding.tvSelectedDate.text = "Eventos del $formattedDate"

        // 🔹 Datos simulados (más adelante se reemplazan por datos reales o de Google Calendar)
        val allEvents = listOf(
            AcademicEvent("Examen de Cálculo I", "08:30", "Unidad 2"),
            AcademicEvent("Entrega Proyecto BD", "23:59", "Subir al Aula Virtual"),
            AcademicEvent("Reunión de grupo", "11:00", "Laboratorio 3"),
            AcademicEvent("Clase de Programación", "10:00", "Tema: Funciones")
        )

        // Filtrar por día (simulación)
        val day = date.get(Calendar.DAY_OF_MONTH)
        val eventsForDay = if (day % 2 == 0) allEvents.take(2) else allEvents.drop(2)

        binding.rvEventsDay.adapter = EventAdapter(eventsForDay)
    }
}
