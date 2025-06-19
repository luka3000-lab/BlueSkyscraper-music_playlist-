package com.example.blueskyscraper

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RatingActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId" , "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val textViewDetails = findViewById<TextView>(R.id.textViewDetails)
        val textViewAvg = findViewById<TextView>(R.id.textViewAverage)

        val btnShow = findViewById<Button>(R.id.btnShowDetails)
        val btnAvg = findViewById<Button>(R.id.btnAvg)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnShow.setOnClickListener {
            val builder = StringBuilder()
            for (i in titles.indices) {
                builder.append("Title: ${titles[i]}\n")
                builder.append("Artist: ${artists[i]}\n")
                builder.append("Rating: ${ratings[i]}\n")
                builder.append("Comment: ${comments[i]}\n\n")
            }
            textViewDetails.text = builder.toString()
        }

        btnAvg.setOnClickListener {
            val average = if (ratings.isNotEmpty()) ratings.sum().toDouble() / ratings.size else 0.0
            textViewAvg.text = "Average Rating: $average"
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
