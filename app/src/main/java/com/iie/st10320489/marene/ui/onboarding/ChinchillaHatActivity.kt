package com.iie.st10320489.marene.ui.onboarding
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.iie.st10320489.marene.R
class ChinchillaHatActivity : AppCompatActivity() {
    private lateinit var chinchillaImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinchilla_hat)

        // Back button functionality
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            finish()
        }

        chinchillaImage = findViewById(R.id.chinchillaImage)

        // Set up hat buttons
        findViewById<View>(R.id.sailorButton).setOnClickListener {
            chinchillaImage.setImageResource(R.drawable.black_sailor)
        }
        findViewById<View>(R.id.mexicanButton).setOnClickListener {
            chinchillaImage.setImageResource(R.drawable.black_mexican)
        }
        findViewById<View>(R.id.strawberryButton).setOnClickListener {
            chinchillaImage.setImageResource(R.drawable.black_strawberry)
        }
        findViewById<View>(R.id.pirateButton).setOnClickListener {
            chinchillaImage.setImageResource(R.drawable.black_pirate)
        }

        // Next button (optional future action)
        findViewById<Button>(R.id.nextButton).setOnClickListener {
            // TODO: Proceed to next step
        }
    }


}