package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragment.databinding.FragmentEnamBinding

class FragmentEnam : Fragment() {

    private var _binding: FragmentEnamBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKembaliAwal.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentEnam_to_fragmentSatu2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}