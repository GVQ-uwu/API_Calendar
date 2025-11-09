package com.example.api_calendar.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.api_calendar.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edUsuario = findViewById<EditText>(R.id.ed_usuario)
        val edContra = findViewById<EditText>(R.id.ed_contra)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val txtMensaje = findViewById<TextView>(R.id.tx_mensaje)

        btnLogin.setOnClickListener {
            val usuario = edUsuario.text.toString().trim()
            val contra = edContra.text.toString().trim()

            when {
                usuario.isEmpty() || contra.isEmpty() -> {
                    txtMensaje.text = "Debe completar ambos campos"
                    txtMensaje.setTextColor(android.graphics.Color.RED)
                }
                contra.length < 8 -> {
                    txtMensaje.text = "La contraseña debe tener mínimo 8 caracteres"
                    txtMensaje.setTextColor(android.graphics.Color.RED)
                }
                usuario == "admin" && contra == "12345678" -> {
                    txtMensaje.text = "Bienvenido"
                    txtMensaje.setTextColor(android.graphics.Color.GREEN)

                    // Ir a HomeActivity
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else -> {
                    txtMensaje.text = "Usuario o contraseña incorrectos"
                    txtMensaje.setTextColor(android.graphics.Color.RED)
                }
            }
        }
    }
}

