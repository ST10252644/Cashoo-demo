package com.iie.st10320489.marene.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.repository.TransactionRepository
import com.iie.st10320489.marene.data.entities.Transaction
import com.iie.st10320489.marene.databinding.FragmentAddBinding
import com.iie.st10320489.marene.viewmodel.TransactionViewModel
import kotlinx.coroutines.launch

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private lateinit var transactionViewModel: TransactionViewModel
    private var selectedPhotoPath: String = ""

    private val categoryList = listOf("Food", "Transport", "Shopping", "Other")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        setupViewModel()
        setupCategoryDropdown()
        setupRadioGroup()

        binding.btnAddEntry.setOnClickListener {
            insertTransaction()
        }

        binding.btnChooseFile.setOnClickListener {
            pickFile()
        }

        return binding.root
    }

    private fun setupViewModel() {
        val db = DatabaseInstance.getDatabase(requireContext())
        val repo = TransactionRepository(db.transactionDao())
        transactionViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                return TransactionViewModel(repo) as T
            }
        }).get(TransactionViewModel::class.java)
    }

    private fun setupCategoryDropdown() {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, categoryList)
        binding.spinnerCategory.setAdapter(adapter)
    }

    private fun setupRadioGroup() {
        binding.rgType.setOnCheckedChangeListener { group, checkedId ->
            val selected = group.findViewById<RadioButton>(checkedId)

            when (selected?.text.toString()) {
                "Expense" -> {
                    binding.etTransactionMethod.isVisible = true
                    binding.etLocation.isVisible = true
                    binding.headingTransactionMethod.isVisible = true
                    binding.headingLocation.isVisible = true
                }
                "Saving", "Income" -> {
                    binding.etTransactionMethod.isVisible = false
                    binding.etLocation.isVisible = false
                    binding.headingTransactionMethod.isVisible = false
                    binding.headingLocation.isVisible = false
                }
            }
        }
    }

    private fun insertTransaction() {
        val name = binding.etName.text.toString()
        val amount = binding.etAmount.text.toString().toDoubleOrNull()
        val method = binding.etTransactionMethod.text.toString()
        val location = binding.etLocation.text.toString()
        val date = binding.etDate.text.toString()
        val description = binding.etDescription.text.toString()
        val categoryName = binding.spinnerCategory.text.toString()

        if (name.isBlank() || amount == null || date.isBlank() || categoryName.isBlank()) {
            Toast.makeText(requireContext(), "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            return
        }

        val selectedType = binding.rgType.checkedRadioButtonId.let { id ->
            binding.rgType.findViewById<RadioButton>(id)?.text?.toString()
        } ?: "Expense"

        val isExpense = when (selectedType) {
            "Expense" -> true
            "Saving" -> false
            "Income" -> false
            else -> true
        }

        val categoryId = getCategoryIdFromName(categoryName)

        val newTransaction = Transaction(
            userId = 1,
            name = name,
            amount = amount,
            transactionMethod = if (binding.etTransactionMethod.isVisible) method else selectedType,
            location = if (binding.etLocation.isVisible) location else selectedType,
            dateTime = date,
            description = description,
            photo = selectedPhotoPath,
            categoryId = categoryId ?: 1,
            subCategoryId = 0,
            expense = isExpense,
            recurring = false
        )

        lifecycleScope.launch {
            transactionViewModel.insert(newTransaction)
            Toast.makeText(requireContext(), "Transaction Added Successfully!", Toast.LENGTH_SHORT).show()
            clearFields()
        }
    }

    private fun clearFields() {
        binding.etName.text?.clear()
        binding.etAmount.text?.clear()
        binding.etTransactionMethod.text?.clear()
        binding.etLocation.text?.clear()
        binding.etDate.text?.clear()
        binding.etDescription.text?.clear()
        binding.spinnerCategory.setText("")
        binding.tvFileName.text = "No File Chosen"
    }

    private fun pickFile() {
        selectedPhotoPath = "path/to/fake/photo.jpg"
        binding.tvFileName.text = "photo.jpg"
        Toast.makeText(requireContext(), "Fake file selected", Toast.LENGTH_SHORT).show()
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
