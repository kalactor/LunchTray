package com.rabarka.lunchtray.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.rabarka.lunchtray.LunchViewModel
import com.rabarka.lunchtray.R
import com.rabarka.lunchtray.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: LunchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            summaryFragment = this@SummaryFragment
            viewModel = sharedViewModel
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun submitOrder() {
        Toast.makeText(requireContext(), "Order submitted :)", Toast.LENGTH_SHORT).show()
    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_summaryFragment_to_startOrderFragment)
    }

}