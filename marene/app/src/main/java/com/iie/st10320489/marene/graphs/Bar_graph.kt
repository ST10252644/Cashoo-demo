package com.iie.st10320489.marene.graphs

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.iie.st10320489.marene.R

class BarGraphActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_bar_graph)

        //val topNav: View = findViewById(R.id.top_nav) // Assuming top_nav exists in your layout
        val barGraph: ProgressBar = findViewById(R.id.bar_graph)
        val textPercentageSpent: TextView = findViewById(R.id.text_percentage_spent)
        val valueTotalBalance: TextView = findViewById(R.id.value_total_balance)
        val valueTotalExpense: TextView = findViewById(R.id.value_total_expense)

        // Get Total Balance and Total Expense values
        val totalBalance = valueTotalBalance.text.toString().replace("R", "").replace(",", "").trim().toDoubleOrNull() ?: 0.0
        val totalExpense = valueTotalExpense.text.toString().replace("R", "").replace(",", "").replace("-", "").trim().toDoubleOrNull() ?: 0.0

        // Calculate percentage spent
        val percentageSpent = if (totalBalance > 0) ((totalExpense / totalBalance) * 100).toInt() else 0

        // Update bar graph progress
        barGraph.progress = percentageSpent

        // Update text dynamically
        textPercentageSpent.text = "You've spent $percentageSpent% of your expenses"

        // Constrain bar graph to top_nav dynamically
       /* topNav.post {
            val topNavHeight = topNav.height
            val layoutParams = barGraph.layoutParams
            layoutParams.height = topNavHeight // Match top nav height
            barGraph.layoutParams = layoutParams
        }*/
    }
}