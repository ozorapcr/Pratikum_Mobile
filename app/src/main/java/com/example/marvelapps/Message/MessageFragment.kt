package com.example.marvelapps.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.marvelapps.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Messages"
        }

        // Siapkan data dummy
        val messageList = listOf(
            MessageModel("Tony Stark", "I am Iron Man", "https://i.pravatar.cc/150?u=tony"),
            MessageModel("Steve Rogers", "I can do this all day", "https://i.pravatar.cc/150?u=steve"),
            MessageModel("Thor Odinson", "Bring me Thanos!", "https://i.pravatar.cc/150?u=thor"),
            MessageModel("Natasha Romanoff", "I'm always picking up after you boys", "https://i.pravatar.cc/150?u=natasha"),
            MessageModel("Bruce Banner", "That's my secret, Cap: I'm always angry", "https://i.pravatar.cc/150?u=bruce"),
            MessageModel("Wanda Maximoff", "You guys know I can move things with my mind, right?", "https://i.pravatar.cc/150?u=wanda"),
            MessageModel("Peter Parker", "I'm just a friendly neighborhood Spider-Man", "https://i.pravatar.cc/150?u=peter")
        )

        // Terapkan MessageAdapter
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItem.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
