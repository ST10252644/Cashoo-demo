package com.iie.st10320489.marene.ui.rewards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iie.st10320489.marene.R

class FragmentRewards : AppCompatActivity() {

    private lateinit var recyclerViewBronze: RecyclerView
    private lateinit var recyclerViewSilver: RecyclerView
    private lateinit var recyclerViewGold: RecyclerView

    private lateinit var bronzeAdapter: RewardsAdapter
    private lateinit var silverAdapter: RewardsAdapter
    private lateinit var goldAdapter: RewardsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_rewards)

        // Bind RecyclerViews
        recyclerViewBronze = findViewById(R.id.recyclerViewBronze2)
        recyclerViewSilver = findViewById(R.id.recyclerViewSilver)
        recyclerViewGold = findViewById(R.id.recyclerViewGold)

        // Layout Managers
        recyclerViewBronze.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewSilver.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewGold.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Sample Rewards
        val bronzeRewards = listOf(
            RewardItem("Croissant", "10 pts", R.drawable.croissants),
            RewardItem("Cappuccino", "15 pts", R.drawable.capuccino_jpg)
        )

        val silverRewards = listOf(
            RewardItem("Sandwich", "20 pts", R.drawable.grilled),
            RewardItem("Graduation", "250 000 pts", R.drawable.kanye)
        )

        val goldRewards = listOf(
            RewardItem("Shoe Cleaning", "30 pts", R.drawable.clean),
            RewardItem("Cashoo Bag", "350 000 pts", R.drawable.kanbag)
        )

        // Adapters
        bronzeAdapter = RewardsAdapter(bronzeRewards)
        silverAdapter = RewardsAdapter(silverRewards)
        goldAdapter = RewardsAdapter(goldRewards)

        // Set adapters to each RecyclerView
        recyclerViewBronze.adapter = bronzeAdapter
        recyclerViewSilver.adapter = silverAdapter
        recyclerViewGold.adapter = goldAdapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

// Find the button and set a click listener
        val nextButton = findViewById<Button>(R.id.ItemClaim)
        nextButton.setOnClickListener {
            val intent = Intent(this, FragmentRewardsTwo::class.java)
            startActivity(intent)
        }

        val helping = findViewById<ImageView>(R.id.helpButton)
        helping.setOnClickListener{
            val intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
    }
}