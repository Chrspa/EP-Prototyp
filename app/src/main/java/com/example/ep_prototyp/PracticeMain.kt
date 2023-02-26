package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class PracticeMain : Fragment() {
    private lateinit var mProfileDatabase:ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_practice_main, container, false)
        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)

        val button=view.findViewById<Button>(R.id.weiterZuReviewButton)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_practice1_to_practice2)

        }

        val notificationButton = view.findViewById<Button>(R.id.notificationButton)
        val recipeText =  view.findViewById<TextView>(R.id.recipePlaceholder)
        val wiederholungenText =  view.findViewById<TextView>(R.id.wiederholungen)

        mProfileDatabase.readRezeptData.observe(viewLifecycleOwner, Observer { rezept ->
            recipeText.text="Immer wenn ich ${rezept[0].rezeptPrompt}, werde ich ${rezept[0].rezeptBehaviour}, danach werde ich ${rezept[0].rezeptCelebration}!"
            wiederholungenText.text="${rezept[0].längeBehaviour} lang/mal"
        })



        notificationButton.setOnClickListener(){
            findNavController().navigate(R.id.action_practice1_to_fragment_notification)

        }


        return view
    }
}