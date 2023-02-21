package com.example.ep_prototyp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ep_prototyp.R
import com.example.ep_prototyp.RecyclerAdapter


class Analysis3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis3, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRating)

        //Hier muss dem Adapter die Liste mit Verhalten übergeben werden
        val adapter = RecyclerAdapter(listOf("Verhalten 1", "Verhalten 2", "Verhalten 3"))

        // Adapter auf RecycleView setzen
        recyclerView.adapter = adapter

        // Layout Manager auf RecyclerView setzen
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        val button=view.findViewById<Button>(R.id.weiterZuAnalysis4Button)

        button.setOnClickListener {
            //alle Eingaben müssen gemacht sein, bevor "Weiter" geklickt werden kann
            findNavController().navigate(R.id.action_analysis3_to_analysis4)
        }


        return view
    }

}