package com.gultendogan.progressbarsliderbarratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.widget.AppCompatTextView
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {
            progressBar.visibility = View.VISIBLE
        }

        buttonStop.setOnClickListener {
            progressBar.visibility = View.INVISIBLE
        }

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textViewResult.visibility = View.VISIBLE
                textViewResult.text = "Result : $p1"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        buttonShow.setOnClickListener {
            val progress = slider.progress
            val getRating = ratingBar.rating

            Log.e("PROGRESS",progress.toString())
            Log.e("RATING",getRating.toString())
        }
    }
}