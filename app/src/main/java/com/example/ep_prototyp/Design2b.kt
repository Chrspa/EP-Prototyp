package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


class Design2b : Fragment() {
    private lateinit var mProfileDatabase:ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_design2b, container, false)

        val button=view.findViewById<Button>(R.id.weiterZuDesign3Button)

        button.setOnClickListener {
            val eingabe=view.findViewById<EditText>(R.id.editBehaviorSize)
            celebrationSpeichern(eingabe)
            Toast.makeText(requireContext(),"Celebration gespeichert!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_design2b_to_design3)
        }




        return view

    }
    private fun celebrationSpeichern(celebration: EditText) {
        mProfileDatabase.readRezeptData.observe(viewLifecycleOwner, Observer { data->
                    mProfileDatabase.updateRezept(Rezept(1,data[0].rezeptBehaviour,data[0].längeBehaviour,celebration.text.toString(),data[0].rezeptPrompt))

        })

    }
}