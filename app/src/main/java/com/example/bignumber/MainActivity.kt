package com.example.bignumber

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var scoreVal = 0
    var triedVal = 0

    var randNum1 = (0..100).random()
    var randNum2 = (0..100).random()

    lateinit var scoreView: TextView
    lateinit var triedView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        scoreView = findViewById(R.id.textView2)
        triedView = findViewById(R.id.textView3)

        val btn1: Button = findViewById(R.id.button1)
        val btn2: Button = findViewById(R.id.button2)

        btn1.setText(randNum1.toString())
        btn2.setText(randNum2.toString())

        btn1.setOnClickListener {
            numberGeneratorAndSet(btn1, btn2)
        }

        btn2.setOnClickListener {
            numberGeneratorAndSet(btn2, btn1)
        }

    }

    fun numberGeneratorAndSet(btn1: Button, btn2: Button) {
        val btn1Val = btn1.text.toString().toInt()
        val btn2Val = btn2.text.toString().toInt()

        if (btn1Val > btn2Val) {
            scoreVal++
        } else {
            scoreVal--
        }

        triedVal++

        scoreView.setText("Score: $scoreVal")
        triedView.setText("Tried: $triedVal")

        randNum1 = (0..100).random()
        randNum2 = (0..100).random()

        btn1.setText(randNum1.toString())
        btn2.setText(randNum2.toString())
    }
}