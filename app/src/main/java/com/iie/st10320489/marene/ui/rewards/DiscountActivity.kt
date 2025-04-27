package com.iie.st10320489.marene.ui.rewards

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.iie.st10320489.marene.R

class DiscountActivity : AppCompatActivity() {

    private lateinit var chipGroup: ChipGroup
    private lateinit var recyclerViewClothing: RecyclerView
    private lateinit var recyclerViewFood: RecyclerView
    private lateinit var recyclerViewAccessories: RecyclerView
    private lateinit var recyclerViewShoes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_discount)

        // Initialize RecyclerViews
        recyclerViewClothing = findViewById(R.id.recyclerViewClothing)
        recyclerViewFood = findViewById(R.id.recyclerViewFood)
        recyclerViewAccessories = findViewById(R.id.recyclerViewAccessories)
        recyclerViewShoes = findViewById(R.id.recyclerViewShoes)
        chipGroup = findViewById(R.id.chipGroup)


        // Set LayoutManagers
        recyclerViewClothing.layoutManager = LinearLayoutManager(this)
        recyclerViewFood.layoutManager = LinearLayoutManager(this)
        recyclerViewAccessories.layoutManager = LinearLayoutManager(this)
        recyclerViewShoes.layoutManager = LinearLayoutManager(this)

        // Setup data
        val clothingDiscounts = listOf(
            Discount("H&M Clothing", "20% off all jeans", R.drawable.zara),
            Discount("Factorie", "Buy 2 shirts for the price of 1 shirt", R.drawable.factorie),
            Discount("Zara", "5 % OFF of all clothes", R.drawable.zara)
        )
        val foodDiscounts = listOf(
            Discount("Starbucks Coffee", "50 % OFF of Coffee", R.drawable.starbuck),
            Discount("Energy Snacks", "Buy 1 and get 1 free on energy bars", R.drawable.bar),
            Discount("Kauai Freebies", "80 % OFF of any Kauai item", R.drawable.kauai)
        )
        val accessoriesDiscounts = listOf(
            Discount("Ray-Bans", "15% off sunglasses", R.drawable.ray),
            Discount("Beanies", "25% off beanies", R.drawable.beanie),
            Discount("Chains and Rings", "15% off sunglasses", R.drawable.rings)
        )
        val shoesDiscounts = listOf(
            Discount("Nike Shoes", "10% off sneakers", R.drawable.jordan4),
            Discount("Shoes Wipers", "Save 60% off on shoe wipers", R.drawable.wipers),
            Discount("SportScene", "15% of on shoe related items at the shop", R.drawable.sportscene),
            Discount("Sneakers", "20% off on all sneakers in Sandton Mall", R.drawable.allsneaks)
        )


        // Setup adapters
        recyclerViewClothing.adapter = DiscountAdapter(clothingDiscounts)
        recyclerViewFood.adapter = DiscountAdapter(foodDiscounts)
        recyclerViewAccessories.adapter = DiscountAdapter(accessoriesDiscounts)
        recyclerViewShoes.adapter = DiscountAdapter(shoesDiscounts)


        // Chip click handling
        findViewById<Chip>(R.id.chipAll).setOnClickListener { showOnly("all") }
        findViewById<Chip>(R.id.chipCloths).setOnClickListener { showOnly("clothing") }
        findViewById<Chip>(R.id.chipFood).setOnClickListener { showOnly("food") }
        findViewById<Chip>(R.id.chipAccess).setOnClickListener { showOnly("accessories") }
        findViewById<Chip>(R.id.chipShoes).setOnClickListener { showOnly("shoes") }


        val backm2 = findViewById<ImageView>(R.id.back2)
            backm2.setOnClickListener {
            val intent = Intent(this, FragmentRewardsTwo::class.java)
            startActivity(intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.disc)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showOnly(category: String) {
        recyclerViewClothing.visibility = if (category == "clothing" || category == "all") View.VISIBLE else View.GONE
        recyclerViewFood.visibility = if (category == "food" || category == "all") View.VISIBLE else View.GONE
        recyclerViewAccessories.visibility = if (category == "accessories" || category == "all") View.VISIBLE else View.GONE
        recyclerViewShoes.visibility = if (category == "shoes" || category == "all") View.VISIBLE else View.GONE
    }
}
