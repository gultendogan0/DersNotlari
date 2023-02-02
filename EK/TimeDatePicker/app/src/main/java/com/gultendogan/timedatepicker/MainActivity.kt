package com.gultendogan.timedatepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTextTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePicker = TimePickerDialog(this@MainActivity,TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                editTextTextTime.setText("$i : $i2")
            },hour,minute,true)
            timePicker.setTitle("Select Hour")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"SET",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"CANCEL",timePicker)

            timePicker.show()
        }

        editTextTextDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this@MainActivity,DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                editTextTextDate.setText("$i3/${i2+1}/$i")
            },year,month,day)

            datePicker.setTitle("Select Date")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"SET",datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"CANCEL",datePicker)

            datePicker.show()
        }
    }
}