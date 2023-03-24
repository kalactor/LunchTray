package com.rabarka.lunchtray.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.rabarka.lunchtray.LunchViewModel
import com.rabarka.lunchtray.R
import com.rabarka.lunchtray.databinding.FragmentExtraDishBinding

class ExtraDishFragment : Fragment() {

    private var _binding: FragmentExtraDishBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: LunchViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExtraDishBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            extraDishFragment = this@ExtraDishFragment
            viewModel = sharedViewModel
        }
    }

    fun goNextScreen() {
        sharedViewModel.totalBillWithTax()
        findNavController().navigate(R.id.action_extraDishFragment_to_summaryFragment)
    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_extraDishFragment_to_startOrderFragment)
    }

}