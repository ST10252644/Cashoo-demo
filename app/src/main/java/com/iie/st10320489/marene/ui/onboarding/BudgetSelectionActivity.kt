package com.iie.st10320489.marene.ui.onboarding
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.iie.st10320489.marene.R
class BudgetSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_budget_selection)


            val categories = listOf(
                "Groceries", "Shopping", "Transport",
                "Entertainment", "Health", "Education", "Home"
            )

            val container = findViewById<LinearLayout>(R.id.categoriesContainer)

            categories.forEach { category ->
                val categoryView = TextView(this).apply {
                    text = category
                    textSize = 16f
                    setTextColor(ContextCompat.getColor(context, android.R.color.black))
                    setPadding(32, 32, 32, 32)
                    background = ContextCompat.getDrawable(context, R.drawable.category_unselected)

                    layoutParams = LinearLayout.LayoutParams(
                        resources.getDimensionPixelSize(R.dimen.category_width),
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        bottomMargin = 16
                    }

                    setOnClickListener {
                        isSelected = !isSelected
                        background = if (isSelected) {
                            ContextCompat.getDrawable(context, R.drawable.category_selected)
                        } else {
                            ContextCompat.getDrawable(context, R.drawable.category_unselected)
                        }
                    }
                }
                container.addView(categoryView)
            }

            // Back button functionality
            findViewById<ImageButton>(R.id.backButton).setOnClickListener {
                finish()
            }

            // Next button example (optional navigation)
            findViewById<Button>(R.id.nextButton).setOnClickListener {
                // Example action
            }
        }
    }
