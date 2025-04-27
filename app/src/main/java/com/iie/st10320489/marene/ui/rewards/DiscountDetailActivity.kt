package com.iie.st10320489.marene.ui.rewards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iie.st10320489.marene.R

class DiscountDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_discount_detail)

        // Retrieve views from layout
        val detailImg: ImageView = findViewById(R.id.detailImg)
        val btnConfirm: Button = findViewById(R.id.btnConfirm)
        val btnCancel: Button = findViewById(R.id.btnCancel)

        // Get the discount image resource from the intent
        val imageResId = intent.getIntExtra("discount_image", -1)
        if (imageResId != -1) {
            detailImg.setImageResource(imageResId)
        }

        // Set up the button click events
        btnConfirm.setOnClickListener {
            Toast.makeText(this, "Discount Confirmed", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, QrActivity::class.java)
            startActivity(intent)

            // Here you can add further actions on confirmation
        }

        btnCancel.setOnClickListener {
            finish() // Simply go back to the previous screen
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.discMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}