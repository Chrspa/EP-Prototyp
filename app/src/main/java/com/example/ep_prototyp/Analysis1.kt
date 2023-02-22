package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class Analysis1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis1, container, false)

        val button=view.findViewById<Button>(R.id.weiterZuAnalysis2Button)

        button.setOnClickListener {
            //wenn noch kein Ziel gespeichert, sollte kein "Weiter" möglich sein
            findNavController().navigate(R.id.action_analysis1_to_analysis2)
        }

        val setGoal = view.findViewById<TextView>(R.id.editGoal)
        val submitButton = view.findViewById<Button>(R.id.submitGoal)


        submitButton.setOnClickListener(){
            //muss neu wegen Layout-Änderungen
        }

        return view
    }
}
