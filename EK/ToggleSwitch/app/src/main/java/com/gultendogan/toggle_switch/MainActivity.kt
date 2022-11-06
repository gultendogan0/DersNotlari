package com.gultendogan.toggle_switch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggleButton.setOnCheckedChangeListener(tbOCC)

        switch1.setOnCheckedChangeListener(cCCL)
    }

    var tbOCC = CompoundButton.OnCheckedChangeListener{ btn:CompoundButton, status : Boolean ->
        Toast.makeText(this,"toggle status : "+status, Toast.LENGTH_LONG).show()
    }

    var cCCL = CompoundButton.OnCheckedChangeListener{ btn:CompoundButton, status : Boolean ->
        toggleButton.visibility = if (status) View.VISIBLE else View.INVISIBLE
    }
}