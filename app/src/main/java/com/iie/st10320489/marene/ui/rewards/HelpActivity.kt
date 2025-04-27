package com.iie.st10320489.marene.ui.rewards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iie.st10320489.marene.R

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_help)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.helpMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backsButton = findViewById<Button>(R.id.helpBack)
        backsButton.setOnClickListener {
            val intent = Intent(this, FragmentRewards::class.java)
            startActivity(intent)
        }

    }
}