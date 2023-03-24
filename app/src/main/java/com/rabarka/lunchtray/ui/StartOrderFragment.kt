package com.rabarka.lunchtray.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rabarka.lunchtray.R
import com.rabarka.lunchtray.databinding.FragmentStartOrderBinding

class StartOrderFragment : Fragment() {

    private var _binding: FragmentStartOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            startOrderFragment = this@StartOrderFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }

    fun goNextScreen(){
        findNavController().navigate(R.id.action_startOrderFragment_to_mainDishFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}