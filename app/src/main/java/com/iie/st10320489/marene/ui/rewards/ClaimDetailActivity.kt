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

class ClaimDetailActivity : AppCompatActivity() {

    private lateinit var imageClaimDetail: ImageView
    private lateinit var confirmButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_claim_detail)

        // Bind the views
        imageClaimDetail = findViewById(R.id.imageClaimDetail)
        confirmButton = findViewById(R.id.btnConfirm)
        cancelButton = findViewById(R.id.btnCancel)

        // Get the data passed from the MainActivity2
        val imageResId = intent.getIntExtra("IMAGE_RES_ID", 0)

        // Set the image on the new page
        imageClaimDetail.setImageResource(imageResId)

        // Set onClickListener for the buttons
        confirmButton.setOnClickListener {
            Toast.makeText(this, "Reward Claimed", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Qr2Activity::class.java)
            startActivity(intent)
            // Handle the confirm button action (e.g., confirm claim)
            finish() // Close the activity
        }

        cancelButton.setOnClickListener {
            // Handle the cancel button action
            finish() // Close the activity without any action
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainClaim)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}