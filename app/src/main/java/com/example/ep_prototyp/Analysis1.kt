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

        val setGoal = view.findViewById<TextView>(R.id.setGoalText)
        val submitButton = view.findViewById<Button>(R.id.submitGoal)
        val feedbackGoal = view.findViewById<TextView>(R.id.feedbackTextGoal)

        submitButton.setOnClickListener(){
            val goal = setGoal.text
            //hier Ziel speichern (room)
            if (setGoal.text.toString() == "gib dein Ziel ein" || setGoal.text.toString() == ""){
                feedbackGoal.text = "Bitte gib ein Ziel ein."
            }
            else {
                feedbackGoal.text = "Dein Ziel lautet $goal." +
                        "Sind alle Kriterien für ein gutes Ziel erfüllt? Dann klicke auf \"Weiter\"" +
                        "Du kannst noch etwas verbessern? Dann gib dein Ziel erneut ein!"
            }
        }

        return view
    }
}
