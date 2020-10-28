package com.example.utsmobilecomputing.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.utsmobilecomputing.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val counter: TextView = root.findViewById(R.id.textinput_counter)
        val plusButton: TextView = root.findViewById(R.id.plus_button)
        val minusButton: TextView = root.findViewById(R.id.minus_button)

        plusButton.setOnClickListener {
            counter.text = (counter.text.toString().toInt() + 1).toString()
        }

        minusButton.setOnClickListener {
            counter.text = (counter.text.toString().toInt() - 1).toString()
        }

        return root
    }
}