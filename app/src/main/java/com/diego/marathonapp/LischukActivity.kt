package com.diego.marathonapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class LischukActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lischuk2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setClick()
    }

    fun setClick() {
        findViewById<ImageView>(R.id.btn_back).setOnClickListener { finish() }
        findViewById<TextView>(R.id.number).setOnClickListener { intentPhone() }
        findViewById<TextView>(R.id.email).setOnClickListener { intentEmail() }
        findViewById<TextView>(R.id.location).setOnClickListener { intentGeo() }
    }

    private fun intentPhone() {
        val number = "+79133865853"
        val intentNumber = Intent(Intent.ACTION_DIAL).apply {
            data = "tel:$number".toUri()
        }
        startActivity(intentNumber)
    }

    private fun intentEmail() {
        val email = "maxim.lischuk@yandex.ru"
        val sub = R.string.subject_for_email
        val mes = R.string.message_for_email
        val intentMail = Intent(Intent.ACTION_SENDTO).apply {
            data = "mailto:".toUri()
            putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            putExtra(Intent.EXTRA_SUBJECT, sub)
            putExtra(Intent.EXTRA_TEXT, mes)
        }
        startActivity(intentMail)
    }

    private fun intentGeo() {
        val latitude : Double = "55.030204".toDouble()
        val longitude : Double = "82.920430".toDouble()
        val uri = "geo:$latitude, $longitude".toUri()
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)

    }
}