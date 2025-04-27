package com.iie.st10320489.marene.ui.subcategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.databinding.FragmentSubcategoryBinding


class SubcategoryFragment : Fragment() {

    private var _binding: FragmentSubcategoryBinding? = null
    private val binding get() = _binding!!

    private val subcategories = mutableListOf("Gym", "School", "Clothes")
    private lateinit var adapter: SubcategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubcategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerViewSubcategories.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewSubcategories.adapter = SubcategoryAdapter(subcategories) { selectedSubcategory ->
            val bundle = Bundle().apply {
                putString("categoryName", selectedSubcategory)
            }
            findNavController().navigate(R.id.action_subcategoryFragment_to_transactionFragment, bundle)
        }
    }

    fun addSubcategory(name: String) {
        subcategories.add(name)
        adapter.notifyItemInserted(subcategories.size - 1)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


