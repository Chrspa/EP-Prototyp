package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView


class Analysis2 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis2, container, false)

        val button=view.findViewById<Button>(R.id.weiterZuAnalysis3Button)

        button.setOnClickListener {
            //Mindestanzahl an Verhaltensweisen festlegen
            findNavController().navigate(R.id.action_analysis2_to_analysis3)

        }

        val setBehavior = view.findViewById<TextView>(R.id.eingabeVerhalten)
        val submitButton = view.findViewById<Button>(R.id.submitBehavior)
        val feedback = view.findViewById<TextView>(R.id.feedbackBehavior)
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerBehaviors1)
        val listOfBehaviors = mutableListOf<String>("Push-Ups", "Liegestütz", "Squats", "Plank")

        submitButton.setOnClickListener(){
            val behavior = setBehavior.text
            if (setBehavior.text.toString() == "Gib ein Verhalten ein" || setBehavior.text.toString() == ""){
                feedback.text = "Bitte gib ein Verhalten ein."
            }
            else {
                //Verhalten speichern (room) + in RecyclerView anzeigen
                recycler
            }
        }



        return view
    }
}