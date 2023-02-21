package com.example.ep_prototyp

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

class Analysis4 : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis4, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRating2)

        //Hier muss dem Adapter die Liste mit Verhalten übergeben werden
        val adapter = RecyclerAdapter(listOf("Verhalten 1", "Verhalten 2", "Verhalten 3"))

        // Adapter auf RecycleView setzen
        recyclerView.adapter = adapter

        // Layout Manager auf RecyclerView setzen
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        val button=view.findViewById<Button>(R.id.weiterZuAnalysis5Button)

        button.setOnClickListener {
            //alle Eingaben müssen gemacht sein, bevor "Weiter" geklickt werden kann
            findNavController().navigate(R.id.action_analysis4_to_analysis5)
        }


        return view
    }
}