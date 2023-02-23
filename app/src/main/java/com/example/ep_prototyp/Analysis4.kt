package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ep_prototyp.R

class Analysis4 : Fragment(), RecyclerAdapter.SeekBarListener {

    private val easeList = mutableListOf<Ease>()
    private lateinit var mProfileDatabase : ProfileViewModel

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

        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)

        // List of Behaviors angelegt, um sie mit Namen der Behaviors zu füllen und dem adapter zu übergeben
        val listOfBehaviors = mutableListOf<String>()

        // Behaviors aus Datenbank auslesen und Behavior-Names in Liste speichern
        mProfileDatabase.readBehaviour.observe(viewLifecycleOwner) { behaviour ->
            for (b in behaviour) {
                listOfBehaviors.add(behaviour[0].beschreibung)
            }
        }

        val button=view.findViewById<Button>(R.id.weiterZuAnalysis5Button)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_analysis4_to_analysis5)
        }


        return view
    }

    data class Ease (val behaviorName : String, var easeValue: Int) //verbindet Position der ViewCard (über die das Verhalten abegrufen werden kann) mit dem Wert der Seekbar

    override fun onSeekBarChanged(position: Int, progress: Int) { //speichert Ease
        val newEase = Ease(position.toString(), progress)
        easeList.add(newEase)
    }
}