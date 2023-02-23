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

class Analysis1 : Fragment() {
    private lateinit var mProfileDatabase:ProfileViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis1, container, false)

        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)

        val inhalt= view.findViewById<EditText>(R.id.editGoal)
        loadData(inhalt)
        val button=view.findViewById<Button>(R.id.weiterZuAnalysis2Button)

        button.setOnClickListener {
            //wenn noch kein Ziel gespeichert, sollte kein "Weiter" möglich sein
            findNavController().navigate(R.id.action_analysis1_to_analysis2)
        }

        val submitButton = view.findViewById<Button>(R.id.submitGoal)


        submitButton.setOnClickListener(){
            var editGoalText=view.findViewById<EditText>(R.id.editGoal)
            uploadGoal(editGoalText.text.toString())
            Toast.makeText(requireContext(),"Dein Ziel wurde festgehalten!",Toast.LENGTH_LONG).show()
        }

        return view
    }
    private fun loadData(username:EditText){
        mProfileDatabase.readData.observe(viewLifecycleOwner, Observer { profil ->
            username.setText(profil[0].goal)
        })

    }
    private fun uploadGoal(editGoal:String){
        mProfileDatabase.readData.observe(viewLifecycleOwner, Observer { profil ->
            mProfileDatabase.updateProfile(Profile(1, profil[0].name, profil[0].notificationZeit, editGoal))
        })


    }
}
