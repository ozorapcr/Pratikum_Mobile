package com.example.marvelapps.Message

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.marvelapps.Message.tutorial.TutorialMessageActivity
import com.example.marvelapps.R
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
            title = "Message"
        }
        setHasOptionsMenu(true)

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
