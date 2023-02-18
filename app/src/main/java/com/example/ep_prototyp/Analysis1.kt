package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R


class Analysis1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis1, container, false)

        val Button=view.findViewById<Button>(R.id.weiterZuAnalysis2Button)

        Button.setOnClickListener {
            findNavController().navigate(R.id.action_analysis1_to_analysis2)

        }



        return view
    }
}
