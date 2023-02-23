package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class Design2b : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_design2b, container, false)

        val button = view.findViewById<Button>(R.id.weiterZuDesign3Button)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_design2b_to_design3)

        }



        return view

    }
}