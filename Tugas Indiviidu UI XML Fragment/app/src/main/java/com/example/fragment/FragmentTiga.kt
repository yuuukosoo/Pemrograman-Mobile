package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragment.databinding.FragmentTigaBinding

class FragmentTiga : Fragment() {

    private var _binding: FragmentTigaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKeTujuh.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentTiga_to_fragmentTujuh)
        }

        binding.btnKeDelapan.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentTiga_to_fragmentDelapan)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}