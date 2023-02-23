package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class PracticeMain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_practice_main, container, false)

        val button=view.findViewById<Button>(R.id.weiterZuReviewButton)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_practice1_to_practice2)

        }

        val notificationButton = view.findViewById<Button>(R.id.notificationButton)

        notificationButton.setOnClickListener(){

        }



        return view
    }
}