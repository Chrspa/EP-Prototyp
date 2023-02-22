package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class Analysis5 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis5, container, false)

        val button=view.findViewById<Button>(R.id.weiterZuDesignAnalysisButton)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_analysis5_to_design)

        }


        var value = 0





        return view
    }
}