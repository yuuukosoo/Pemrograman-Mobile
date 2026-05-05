package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragment.databinding.FragmentEmpatBinding

class FragmentEmpat : Fragment() {

    private var _binding: FragmentEmpatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmpatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKeSembilan.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentEmpat_to_fragmentSembilan)
        }

        binding.btnKeSepuluh.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentEmpat_to_fragmentSepuluh)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}