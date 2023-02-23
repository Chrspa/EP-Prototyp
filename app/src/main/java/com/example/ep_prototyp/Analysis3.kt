package com.example.ep_prototyp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.graphics.component1
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ep_prototyp.R
import com.example.ep_prototyp.RecyclerAdapter


class Analysis3 : Fragment(), RecyclerAdapter.SeekBarListener {

    private val efficiencies = mutableListOf<Efficiency>()
    private lateinit var adapter : RecyclerAdapter
    private lateinit var mProfileDatabase : ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis3, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRating)
        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)

        // List of Behaviors angelegt, um sie mit Namen der Behaviors zu füllen und dem adapter zu übergeben

        val listOfBehaviors = mutableListOf<String>()
        // Behaviors aus Datenbank auslesen und Behavior-Names in Liste speichern
        mProfileDatabase.readBehaviour.observe(viewLifecycleOwner, Observer { behaviour ->
            for (b in behaviour){
                listOfBehaviors.add(b.beschreibung)
            }
            adapter = RecyclerAdapter(listOfBehaviors)
            adapter.setSeekBarListener(this)
            recyclerView.adapter = adapter
        })


        // Liste mit Verhalten übergeben, um sie im RecyclerView anzuzeigen


        // Adapter auf RecycleView setzen

        // Layout Manager auf RecyclerView setzen
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager


        val button=view.findViewById<Button>(R.id.weiterZuAnalysis4Button)

        button.setOnClickListener {
            for(i in adapter.list){

                Toast.makeText(requireContext(),"die Efficiency ist von ${i.toString()} = ${i.toString()}" ,Toast.LENGTH_SHORT).show()
            }
         //  addBehaviourEfficiency()
            //alle Eingaben müssen gemacht und gespeichert sein, bevor "Weiter" geklickt werden kann
            //    findNavController().navigate(R.id.action_analysis3_to_analysis4)
                //Toast: Bitte erst alle Angaben machen
            findNavController().navigate(R.id.action_analysis3_to_analysis4)
        }

        return view
    }

    private fun addBehaviourEfficiency(listOfBehaviors:List<Behaviour>) {



    }

    data class Efficiency (val behaviorName : String, var efficiencyValue: Int) //verbindet Position der ViewCard (über die das Verhalten abegrufen werden kann) mit dem Wert der Seekbar

    override fun onSeekBarChanged(position: Int, progress: Int) { //speichert Efficiency
        val newEfficiency = Efficiency(position.toString(), progress)
        efficiencies.add(newEfficiency)
    }

}