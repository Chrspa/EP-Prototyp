package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class Review : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_review, container, false)
        val button=view.findViewById<Button>(R.id.weiterZuReview2Button)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_review_to_review2b)

        }



        return view
    }
}