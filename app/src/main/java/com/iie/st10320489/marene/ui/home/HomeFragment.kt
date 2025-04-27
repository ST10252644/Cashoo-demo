package com.iie.st10320489.marene.ui.home

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iie.st10320489.marene.data.dao.TransactionDao
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.entities.Transaction
import com.iie.st10320489.marene.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var transactionDao: TransactionDao
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Setup RecyclerView
        transactionAdapter = TransactionAdapter(emptyList())
        binding.transactionRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = transactionAdapter
        }

        // Setup Database
        val database = DatabaseInstance.getDatabase(requireContext())
        transactionDao = database.transactionDao()

        // Fetch Data
        lifecycleScope.launch {
            loadTransactions()
        }

        return root
    }

    private fun loadTransactions() {
        // Get the last two transactions from the database
        val transactions = getLastTwoTransactions()

        // Update the adapter with the new data
        transactionAdapter.updateTransactions(transactions)
    }

    private fun getLastTwoTransactions(): List<Transaction> {
        val transactions: MutableList<Transaction> = ArrayList()

        // Use Room's DAO to query the last two transactions
        lifecycleScope.launch {
            // Assuming `transactionDao` has a method `getLastTwoTransactions()` that returns a list of transactions.
            transactions.addAll(transactionDao.getLastTwoTransactions())

            // Update the adapter with the new data
            transactionAdapter.updateTransactions(transactions)
        }

        return transactions
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
