package com.gultendogan.narutorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gultendogan.narutorecyclerview.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val selectedNaruto = intent.getSerializableExtra("naruto") as Naruto
        binding.nameText.text =selectedNaruto.name
        binding.detailsText.text = selectedNaruto.info
        binding.imageView.setImageResource(selectedNaruto.image)
    }
}