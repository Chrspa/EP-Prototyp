package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView


class Analysis2 : Fragment() {
    private lateinit var mProfileDatabase:ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)

            // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis2, container, false)
        val eingabe = view.findViewById<EditText>(R.id.editBehavior)
        val button=view.findViewById<Button>(R.id.weiterZuAnalysis3Button)

        button.setOnClickListener {
            //Mindestanzahl an Verhaltensweisen festlegen
            findNavController().navigate(R.id.action_analysis2_to_analysis3)

        }

        val submitButton = view.findViewById<Button>(R.id.submitBehavior)

        val listOfBehaviors = mutableListOf<String>("Push-Ups", "Liegestütz", "Squats", "Plank")

        submitButton.setOnClickListener(){
            addBehaviour(eingabe)

        }
        return view
    }

    private fun addBehaviour(eingabe: EditText) {
        mProfileDatabase.addBehaviour(Behaviour(0,eingabe.text.toString()))
        Toast.makeText(requireContext(),"Behaviour hinzugefügt",Toast.LENGTH_SHORT).show()
        eingabe.setText(" ")
    }
}

