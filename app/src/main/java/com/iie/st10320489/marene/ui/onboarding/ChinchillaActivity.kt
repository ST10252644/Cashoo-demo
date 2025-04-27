package com.iie.st10320489.marene.ui.onboarding

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.iie.st10320489.marene.R

class ChinchillaActivity : AppCompatActivity(){

    private lateinit var chinchillaImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinchilla)

        // Back button functionality
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            finish()
        }

        chinchillaImage = findViewById(R.id.chinchillaImage)

        // Set up color buttons
        findViewById<View>(R.id.whiteButton).setOnClickListener {
            chinchillaImage.setImageResource(R.drawable.white_nohat)
        }
        findViewById<View>(R.id.beigeButton).setOnClickListener {
            chinchillaImage.setImageResource(R.drawable.beige_nohat)
        }
        findViewById<View>(R.id.violetButton).setOnClickListener {
            chinchillaImage.setImageResource(R.drawable.voilet_nohat)
        }
        findViewById<View>(R.id.brownButton).setOnClickListener {
            chinchillaImage.setImageResource(R.drawable.brown_nohat)
        }
        findViewById<View>(R.id.blackButton).setOnClickListener {
            chinchillaImage.setImageResource(R.drawable.black_nohat)
        }
        findViewById<View>(R.id.greyButton).setOnClickListener {
            chinchillaImage.setImageResource(R.drawable.grey_nohat)
        }

        // Next button click (optional action here)
        findViewById<Button>(R.id.nextButton).setOnClickListener {
            // TODO: Move to next screen
        }
    }

}