package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class Analysis1 : Fragment() {

    private lateinit var popupWindow: PopupWindow

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis1, container, false)
        val popupView = inflater.inflate(R.layout.pop_up_zusatzinfo_layout, null)
        val button=view.findViewById<Button>(R.id.weiterZuAnalysis2Button)

        popupWindow = PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)

        val popupHeader = popupView.findViewById<TextView>(R.id.textViewExamplesHeader)
        val popUpExamples = popupView.findViewById<TextView>(R.id.textViewExamples)

        //Pop-Up-TextViews befüllen
        popupHeader.text = "Hier einige Beispiel-Ziele:"
        popUpExamples.text = getString(R.string.examplesGoal)

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
