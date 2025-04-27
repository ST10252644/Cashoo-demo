package com.iie.st10320489.marene.ui.onboarding

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.iie.st10320489.marene.R

class SavingsGoalActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings_goal)

        // Back button functionality
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            finish()
        }

        // Set up dropdown spinner
        val spinner: Spinner = findViewById(R.id.paydaySpinner)
        val items = arrayOf("Select your payday", "Weekly", "Bi-weekly", "Monthly")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner.adapter = adapter
        // Sliders and text updates
        val salarySlider = findViewById<SeekBar>(R.id.salarySlider)
        val minSavingsSlider = findViewById<SeekBar>(R.id.minSavingsSlider)
        val maxSpendingSlider = findViewById<SeekBar>(R.id.maxSpendingSlider)

        val salaryValue = findViewById<TextView>(R.id.salaryValue)
        val minSavingsValue = findViewById<TextView>(R.id.minSavingsValue)
        val maxSpendingValue = findViewById<TextView>(R.id.maxSpendingValue)

        salarySlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                salaryValue.text = "R$progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        minSavingsSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                minSavingsValue.text = "R$progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        maxSpendingSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                maxSpendingValue.text = "R$progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Next button listener (example)
        findViewById<Button>(R.id.nextButton).setOnClickListener {
            Toast.makeText(this, "Next clicked", Toast.LENGTH_SHORT).show()
        }
    }

}