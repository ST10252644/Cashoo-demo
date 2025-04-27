package com.iie.st10320489.marene.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set up RecyclerView
        binding.recyclerViewCategories.layoutManager = GridLayoutManager(requireContext(), 3)

        // Set adapter with click listener
        val adapter = CategoryAdapter(getCategoryList()) { category ->
            val bundle = Bundle().apply {
                putString("categoryName", category.catTitle)
            }

            if (category.catTitle == "Custom") {
                findNavController().navigate(R.id.action_categoryFragment_to_subcategoryFragment, bundle)
            } else {
                findNavController().navigate(R.id.action_categoryFragment_to_transactionFragment, bundle)
            }
        }


        binding.recyclerViewCategories.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getCategoryList(): List<CategoryModel> {
        return listOf(
            CategoryModel(R.drawable.ic_house, "House", R.color.rose),
            CategoryModel(R.drawable.ic_food, "Food", R.color.blue),
            CategoryModel(R.drawable.ic_transport, "Transport", R.color.purple),
            CategoryModel(R.drawable.ic_health, "Health", R.color.orange),
            CategoryModel(R.drawable.ic_loans, "Loans", R.color.tangerine),
            CategoryModel(R.drawable.ic_entertainment, "Entertainment", R.color.pink),
            CategoryModel(R.drawable.ic_family, "Family", R.color.yellow),
            CategoryModel(R.drawable.ic_custom, "Custom", R.color.teal_200),
            CategoryModel(R.drawable.ic_savings, "Savings", R.color.nav_active)
        )
    }
}
