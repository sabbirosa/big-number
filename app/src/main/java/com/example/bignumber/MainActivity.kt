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
            numberGeneratorAndSet(randNum1, randNum2, btn2)
            randNum2 = (0..100).random()
            btn1.setText(randNum2.toString())
        }

        btn2.setOnClickListener {
            numberGeneratorAndSet(randNum2, randNum1, btn1)
            randNum2 = (0..100).random()
            btn2.setText(randNum2.toString())
        }


    }

    fun numberGeneratorAndSet(num1: Int, num2: Int, btn: Button) {
        if (num1 > num2) {
            scoreVal++
            triedVal++

        } else {
            scoreVal--
            triedVal++
        }

        scoreView.setText("Score: $scoreVal")
        triedView.setText("Tried: $triedVal")

        randNum1 = (0..100).random()
        btn.setText(randNum1.toString())
    }
}