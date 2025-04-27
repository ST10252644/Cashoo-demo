package com.iie.st10320489.marene.ui.analysis

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.google.android.material.tabs.TabLayout
import com.iie.st10320489.marene.R


class AnalysisFragment : Fragment() {

    private lateinit var pieChart: PieChart
    private lateinit var barChart: BarChart
    private lateinit var tabLayout: TabLayout
    private val viewModel: AnalysisViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_analysis, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pieChart = view.findViewById(R.id.pieChart)
        barChart = view.findViewById(R.id.barChart)
        tabLayout = view.findViewById(R.id.tabLayout)

        setupPieChart()
        setupTabs()


    }

    private fun setupPieChart() {
        val entries = listOf(
            PieEntry(62.5f, "Food"),
            PieEntry(25f, "Health"),
            PieEntry(12.5f, "Transport")
        )

        val colors = listOf(
            Color.parseColor("#F39C12"),
            Color.parseColor("#5C6BC0"),
            Color.parseColor("#EC407A")
        )

        val dataSet = PieDataSet(entries, "").apply {
            this.colors = colors
            valueTextColor = Color.TRANSPARENT
        }

        val data = PieData(dataSet)

        pieChart.data = data
        pieChart.description.isEnabled = false
        pieChart.legend.isEnabled = false
        pieChart.setDrawEntryLabels(false)
        pieChart.setHoleColor(Color.WHITE)
        pieChart.setDrawCenterText(false)
        pieChart.animateY(1000)
        pieChart.invalidate()
    }

    private fun setupTabs() {
        tabLayout.addTab(tabLayout.newTab().setText("Weekly"))
        tabLayout.addTab(tabLayout.newTab().setText("Monthly"), true)
        tabLayout.addTab(tabLayout.newTab().setText("Yearly"))

        setChartData("Monthly")

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                setChartData(tab.text.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun setChartData(mode: String) {
        val incomeEntries = ArrayList<BarEntry>()
        val expenseEntries = ArrayList<BarEntry>()

        val labels = when (mode) {
            "Weekly" -> arrayListOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
            "Monthly" -> arrayListOf("W1", "W2", "W3", "W4")
            "Yearly" -> arrayListOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul")
            else -> arrayListOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        }

        for (i in labels.indices) {
            incomeEntries.add(BarEntry(i.toFloat(), (1000..10000).random().toFloat()))
            expenseEntries.add(BarEntry(i.toFloat(), (500..8000).random().toFloat()))
        }

        val incomeDataSet = BarDataSet(incomeEntries, "Income").apply {
            color = Color.parseColor("#36CFC9")
        }

        val expenseDataSet = BarDataSet(expenseEntries, "Expenses").apply {
            color = Color.parseColor("#FF6B81")
        }

        val barData = BarData(incomeDataSet, expenseDataSet).apply {
            barWidth = 0.3f
        }

        barChart.data = barData

        val groupSpace = 0.2f
        val barSpace = 0.05f

        val xAxis = barChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        xAxis.position = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.granularity = 1f
        xAxis.labelCount = labels.size
        xAxis.textColor = Color.BLACK

        barChart.axisLeft.axisMinimum = 0f
        barChart.axisRight.isEnabled = false

        val groupWidth = barData.getGroupWidth(groupSpace, barSpace)
        barChart.xAxis.axisMinimum = 0f
        barChart.xAxis.axisMaximum = 0f + groupWidth * labels.size
        barChart.groupBars(0f, groupSpace, barSpace)

        barChart.description = com.github.mikephil.charting.components.Description().apply { text = "" }
        barChart.setFitBars(true)
        barChart.isDoubleTapToZoomEnabled = false
        barChart.invalidate()
    }

}