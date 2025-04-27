package com.iie.st10320489.marene.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.ViewModelProvider
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.repository.TransactionRepository
import com.iie.st10320489.marene.databinding.FragmentHomeSearchBinding
import com.iie.st10320489.marene.viewmodel.TransactionViewModel
import kotlinx.coroutines.launch

class HomeFragmentSearch : Fragment() {

    private var _binding: FragmentHomeSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var transactionViewModel: TransactionViewModel
    private var categoryList: List<String> = listOf("Food", "Transport", "Shopping", "Other") // Replace with real data if needed

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeSearchBinding.inflate(inflater, container, false)

        // Step 1 - Setup database, DAO, Repo, ViewModel
        val db = DatabaseInstance.getDatabase(requireContext())
        val transactionDao = db.transactionDao()
        val repo = TransactionRepository(transactionDao)
        transactionViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                return TransactionViewModel(repo) as T
            }
        }).get(TransactionViewModel::class.java)

        setupCategoryDropdown()

        binding.btnSearch.setOnClickListener {
            performSearch()
        }

        return binding.root
    }

    private fun setupCategoryDropdown() {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, categoryList)
        binding.spinnerCategory.setAdapter(adapter)
    }

    private fun performSearch() {
        val selectedCategory = binding.spinnerCategory.text.toString()
        val selectedDate = binding.etDate.text.toString()

        val categoryId = getCategoryIdFromName(selectedCategory)
        val dateQuery = if (selectedDate.isNotBlank()) selectedDate else null

        lifecycleScope.launch {
            transactionViewModel.searchTransactions(categoryId, dateQuery).collect { transactions ->
                // Here, update your RecyclerView/ListView (not done in this example)
                // For now, just log the results or you can Toast it
                transactions.forEach {
                    println("Found transaction: ${it.name} amount ${it.amount}")
                }
            }
        }
    }

    private fun getCategoryIdFromName(name: String): Int? {
        return when (name) {
            "Food" -> 1
            "Transport" -> 2
            "Shopping" -> 3
            "Other" -> 4
            else -> null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
