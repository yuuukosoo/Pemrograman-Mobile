package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragment.databinding.FragmentDuaBinding

class FragmentDua : Fragment() {

    private var _binding: FragmentDuaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDuaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKeLima.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentDua_to_fragmentLima)
        }

        binding.btnKeEnam.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentDua_to_fragmentEnam)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}