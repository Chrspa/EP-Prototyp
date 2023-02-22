package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class Design : Fragment() {

    lateinit var textDesign : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_design, container, false)

        val button=view.findViewById<Button>(R.id.weiterZuDesign2Button)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_design_to_design2)

        }

        textDesign.text = "Super, du hast die Analyse-Phase erfolgreich durchlaufen und ein Golden Habit für dein Verhaltensrezept ausgewählt. \n\n " +
                "Als nächstes legst du einen Umfang für dein Verhalten fest. Dies kann eine Zeitangabe sein oder eine feste Anzahl an Wiederholungen." +
                "Für Beispiele klicke hier."

        return view
    }
}