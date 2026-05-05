package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragment.databinding.FragmentSatuBinding

class FragmentSatu : Fragment() {

    private var _binding: FragmentSatuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSatuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKeDua.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSatu2_to_fragmentDua)
        }

        binding.btnKeTiga.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSatu2_to_fragmentTiga)
        }

        binding.btnKeEmpat.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSatu2_to_fragmentEmpat)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}