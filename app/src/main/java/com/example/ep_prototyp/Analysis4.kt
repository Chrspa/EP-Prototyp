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

    private lateinit var mProfileDatabase : ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis4, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRating2)
        mProfileDatabase= ViewModelProvider(this)[ProfileViewModel::class.java]



        val listOfBehaviors2 = mutableListOf<String>()
        // Behaviors aus Datenbank auslesen und Behavior-Names in Liste speichern
        mProfileDatabase.readBehaviour.observe(viewLifecycleOwner, Observer { behaviour ->
            for (b in behaviour){
                listOfBehaviors2.add(b.beschreibung)
            }
            var adapter = RecyclerAdapter(listOfBehaviors2)
            adapter.setSeekBarListener(this)
            recyclerView.adapter = adapter
        })



        // Layout Manager auf RecyclerView setzen
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        val button=view.findViewById<Button>(R.id.weiterZuAnalysis5Button)

        button.setOnClickListener {
            if (easeList.size == listOfBehaviors2.size){
                //@Chris Bitte hier alle progress-Ints aus der ease-Liste den Behaviors in der Datenbank zuordnen
            }
            findNavController().navigate(R.id.action_analysis4_to_analysis5)
        }

        return view
    }

    data class Ease (val position : Int, var easeValue: Int) //verbindet Position der ViewCard (über die das Verhalten abegrufen werden kann) mit dem Wert der Seekbar
    val easeList = mutableListOf<Ease>()


    override fun onSeekBarChanged(position: Int, progress: Int) { //speichert Ease
        val existingEase = easeList.find { it.position == position }
        if (existingEase != null) {
            existingEase.easeValue = progress
        } else {
            val newEase = Ease (position, progress)
            easeList.add(newEase)
        }
    }
}