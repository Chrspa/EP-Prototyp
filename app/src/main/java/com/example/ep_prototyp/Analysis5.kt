package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ep_prototyp.R
import com.google.android.material.search.SearchView.Behavior

class Analysis5 : Fragment() {

    private lateinit var mProfileDatabase : ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis5, container, false)

        val button=view.findViewById<Button>(R.id.weiterZuDesignAnalysisButton)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_analysis5_to_design)

        }

        class Behavior (val id:Int,
                             val beschreibung:String,
                             val effizienz:Int?=null,
                             val einfachheit:Int?=null)

        val listOfBehaviour = mutableListOf<Behavior>()

        mProfileDatabase.readBehaviour.observe(viewLifecycleOwner, Observer { behaviour ->
            for (b in behaviour){
                val newBehavior = Behavior(b.id, b.beschreibung, b.effizienz, b.einfachheit)
                listOfBehaviour.add(newBehavior)
            }
        })

        //Hier evtl Asynchronität ein Problem?
        listOfBehaviour.sortByDescending { it.einfachheit }
        listOfBehaviour.sortByDescending { it.beschreibung }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewGoldenBehaviors)




        return view
    }
}