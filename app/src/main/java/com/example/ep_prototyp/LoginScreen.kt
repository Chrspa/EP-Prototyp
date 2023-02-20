package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class LoginScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login_screen, container, false)

        val buttonIntroduction=view.findViewById<Button>(R.id.weiterZuIntroductionLoginButton)

        buttonIntroduction.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_introduction)
        }
        val buttonAnalysis1=view.findViewById<Button>(R.id.weiterZuAnalysisLoginButton)

        buttonAnalysis1.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_analysis1)
        }

        val editName = view.findViewById<TextView>(R.id.editNametext)
        val submitButton = view.findViewById<Button>(R.id.submitButton1)
        val feedback = view.findViewById<TextView>(R.id.feedbackText)

        submitButton.setOnClickListener(){
            val profileName = editName.text
            //dann profileName in room speichern
            if (editName.text == "Dein Name" || editName.text == ""){
                feedback.text = "Bitte gib einen Namen ein."
            }
            else{
                feedback.text = "Hallo $profileName!. Klicke auf \"Start\" um loszulegen oder auf \"Einführung\", \" +\n" +
                                    "\"wenn du mehr zum Prinzip der App und zum Ablauf erfahren möchtest."
            }
        }



        return view
    }



}