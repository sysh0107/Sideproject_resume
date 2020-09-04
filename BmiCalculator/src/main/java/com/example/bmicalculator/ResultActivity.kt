package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()

        val bmi = weight/Math.pow (height/100.0, 2.0)

        when{
            bmi >= 35 -> resultTextView.text = "고도비만"
            bmi >= 30 -> resultTextView.text = "2단계 비만"
            bmi >= 25 -> resultTextView.text = "1단계 비만"
            bmi >= 23 -> resultTextView.text = "과체중"
            bmi >= 18.5 -> resultTextView.text = "정상"
            else ->  resultTextView.text = "저체중"
        }

        when{
            bmi >= 23 ->
                imageView.setImageResource(R.drawable.ic_baseline_arrow_upward_24)
            bmi >= 18.5 ->
                imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
            else -> imageView.setImageResource(R.drawable.ic_baseline_arrow_downward_24)
        }
        toast("$bmi")
    }

}