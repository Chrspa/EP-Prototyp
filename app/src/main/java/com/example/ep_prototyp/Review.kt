package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class Review : Fragment() {
    private lateinit var mProfileDatabase:ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_review, container, false)
        val button=view.findViewById<Button>(R.id.weiterZuReview2Button)
        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)
        val infoTextPractice=view.findViewById<TextView>(R.id.infoTextPractice)

        mProfileDatabase.readWeekData.observe(viewLifecycleOwner, Observer { data ->
            var i :Int =data[0].erledigt
            Toast.makeText(requireContext(),data[0].erledigt.toString(), Toast.LENGTH_SHORT).show()

           val ausgabe = when(i) {
                0, 1, 2 ->
                    "das sieht aus als hättest du noch ein Paar Probleme mit deinem Rezept, aber keine Sorge! lass uns nochmal anschauen woran es liegen könnte"
                3, 4, 5 ->
                    "das sieht aus als hättest du noch ein Paar Probleme mit deinem Rezept, aber keine Sorge! lass uns nochmal anschauen woran es liegen könnte"
                6, 7 ->
                    "das Funktioniert Top! Immer weiter so, dann wirst du schon bald ein neues Behaviour erlangen!"
               else -> {"ups"}
           }
            infoTextPractice.text = ausgabe

        })



        button.setOnClickListener {
            findNavController().navigate(R.id.action_review_to_review2b)

        }



        return view
    }
}