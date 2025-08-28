package com.diego.marathonapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<MaterialButton>(R.id.btn_egorov).setOnClickListener {
            startActivity(Intent(this, EgorovActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.btn_lischuk).setOnClickListener {
            startActivity(Intent(this, LischukActivity::class.java))
        }

        findViewById<Button>(R.id.btn_random).setOnClickListener {
            val random = Random.nextInt(1, 3)

            when(random){
                1 -> { startActivity(Intent(this, EgorovActivity::class.java)) }
                2 -> { startActivity(Intent(this, LischukActivity::class.java)) }
            }
        }

    }
}