package com.example.marvelapps.Message.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.marvelapps.R
import com.example.marvelapps.databinding.FragmentTutorial1Binding

class Tutorial1Fragment : Fragment() {
    private var _binding: FragmentTutorial1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTutorial1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set konten spesifik Tutorial 1 (Background, Logo, Judul, Deskripsi)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}