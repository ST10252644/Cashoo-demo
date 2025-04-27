package com.iie.st10320489.marene.ui.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.databinding.FragmentTransactionBinding

class TransactionFragment : Fragment() {
    private var binding: FragmentTransactionBinding? = null
    private var selectedCategory: String? = null
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve category from arguments
        selectedCategory = arguments?.getString("categoryName")

        // Filter transactions
        val filteredTransactions = transactionList.filter { it.transactionCategory == selectedCategory }

        // Set up RecyclerView with item click listener
        transactionAdapter = TransactionAdapter(filteredTransactions) { selectedTransaction ->
            val bundle = Bundle().apply {
                putParcelable("transaction", selectedTransaction)
            }
            view.findNavController().navigate(R.id.action_transactionFragment_to_transactionDetailsFragment, bundle)
        }

        binding!!.recyclerViewTransactions.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = transactionAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private val transactionList: List<TransactionModel>
        get() {
            return listOf(
                TransactionModel(R.drawable.ic_food, "Groceries", 150.75, true, "Card", "2024-03-01", R.color.blue, "Food", "Checkers, Cape Town", "Weekly grocery run", "uri://photo1"),
                TransactionModel(R.drawable.ic_food, "Restaurant", 340.00, true, "Card", "2024-03-10", R.color.blue, "Food", "Spur, Joburg", "Dinner with friends", "uri://photo2"),
                TransactionModel(R.drawable.ic_food, "Groceries", 1273.00, true, "Card", "2024-03-12", R.color.blue, "Food", "Pick n Pay, Durban", "Monthly bulk shopping", "uri://photo3"),
                TransactionModel(R.drawable.ic_food, "Coffee", 54.00, true, "Card", "2024-03-13", R.color.blue, "Food", "Starbucks", "Morning coffee", "uri://photo4"),
                TransactionModel(R.drawable.ic_transport, "Uber Ride", 25.50, true, "Cash", "2024-03-02", R.color.purple, "Transport", "Cape Town CBD", "Quick trip to meeting", "uri://photo5"),
                TransactionModel(R.drawable.ic_house, "Rent", 2000.00, true, "Bank Transfer", "2024-03-01", R.color.rose, "House", "Claremont", "March rent payment", "uri://photo6"),
                TransactionModel(R.drawable.ic_house, "Water", 500.00, true, "Bank Transfer", "2024-03-10", R.color.rose, "House", "Claremont", "Municipal water bill", "uri://photo7"),
                TransactionModel(R.drawable.ic_house, "Electricity", 600.00, true, "Bank Transfer", "2024-03-10", R.color.rose, "House", "Claremont", "Prepaid electricity", "uri://photo8"),
                TransactionModel(R.drawable.ic_custom, "Gym membership", 200.00, true, "Bank Transfer", "2024-03-10", R.color.teal_200, "Gym", "Planet Fitness", "Monthly membership", "uri://photo9"),
                TransactionModel(R.drawable.ic_savings, "Salary", 3000.00, false, "Bank Transfer", "2024-03-03", R.color.nav_active, "Savings", "Cape Town", "March salary deposit", "uri://photo10")
            )
        }

}
