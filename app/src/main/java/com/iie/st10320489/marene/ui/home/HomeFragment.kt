package com.iie.st10320489.marene.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.iie.st10320489.marene.databinding.FragmentHomeBinding
import com.iie.st10320489.marene.R

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Navigate to HomeTransactionFragment when button is clicked
        binding.seeMoreTransactionsButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_homeTransactionFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
