package com.iie.st10320489.marene.ui.rewards

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iie.st10320489.marene.R

class FragmentRewardsTwo : AppCompatActivity() {

    private lateinit var recyclerClmBronze: RecyclerView
    private lateinit var recyclerClmSilver: RecyclerView
    private lateinit var recyclerClmGold: RecyclerView

    private lateinit var bronClmAdapter: ClaimsAdapter
    private lateinit var silClmAdapter: ClaimsAdapter
    private lateinit var gldClmAdapter: ClaimsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_rewardstwo)


        // Bind RecyclerViews
        recyclerClmBronze = findViewById(R.id.recyclerClaimBronze)
        recyclerClmSilver = findViewById(R.id.recyclerClaimSilver)
        recyclerClmGold = findViewById(R.id.recyclerClaimGold)

        // Layout Managers
        recyclerClmBronze.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerClmSilver.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerClmGold.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Sample Rewards
        val bronzeClaims = listOf(
            ClaimItem("Croissant", "5 pts", R.drawable.croissants),
            ClaimItem("Cappuccino", "8 pts", R.drawable.capuccino_jpg),
            ClaimItem("Choco Cookie", "10 pts", R.drawable.cookie),
            ClaimItem("Frappe", "12 pts", R.drawable.frappe)
        )

        val silverClaims = listOf(
            ClaimItem("Sandwich", "15 pts", R.drawable.grilled),
            ClaimItem("Graduation", "18 pts", R.drawable.kanye),
            ClaimItem("Journal", "20 pts", R.drawable.journal),
            ClaimItem("Energy Pack", "22 pts", R.drawable.energy)
        )

        val goldClaims = listOf(
            ClaimItem("Shoe Cleaning", "25 pts", R.drawable.clean),
            ClaimItem("Cashoo Bag", "40 pts", R.drawable.kanbag),
            ClaimItem("Two Burritos", "35 pts", R.drawable.burrito),
            ClaimItem("Jordan 4s", "50 pts", R.drawable.jordan4)
        )

        // Adapters
        bronClmAdapter = ClaimsAdapter(bronzeClaims)
        silClmAdapter = ClaimsAdapter(silverClaims)
        gldClmAdapter = ClaimsAdapter(goldClaims)

        // Set adapters to each RecyclerView
        recyclerClmBronze.adapter = bronClmAdapter
        recyclerClmSilver.adapter = silClmAdapter
        recyclerClmGold.adapter = gldClmAdapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val discPage = findViewById<TextView>(R.id.discPage)
        discPage.setOnClickListener{
            val intent = Intent(this, DiscountActivity::class.java)
            startActivity(intent)
        }

        val backs = findViewById<ImageView>(R.id.back)
        backs.setOnClickListener{
            val intent = Intent(this, FragmentRewards::class.java)
            startActivity(intent)
        }
    }
}