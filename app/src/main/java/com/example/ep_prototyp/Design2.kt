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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class Design2 : Fragment() {
    private lateinit var mProfileDatabase:ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_design2, container, false)
        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)


        val button=view.findViewById<Button>(R.id.weiterZuDesign2bButton)

        button.setOnClickListener {
            val eingabe=view.findViewById<EditText>(R.id.editBehaviorSize)
            promptSpeichern(eingabe)
            Toast.makeText(requireContext(),"Prompt Gespeichert!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_design2_to_design2b)
        }


        return view
    }
    private fun promptSpeichern(prompt:EditText) {
        mProfileDatabase.readRezeptData.observe(viewLifecycleOwner, Observer { data->
                    mProfileDatabase.updateRezept(Rezept(1,data[0].rezeptBehaviour,data[0].längeBehaviour,data[0].rezeptCelebration,prompt.text.toString()))

        })

    }
}