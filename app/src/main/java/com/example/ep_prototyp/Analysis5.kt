package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
        val recyclerView2 = view.findViewById<RecyclerView>(R.id.recyclerViewGoldenBehaviors)

        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)




        val listOfBehaviour = mutableListOf<BehaviorItems>()

        // Ab hier evtl Asynchronität ein Problem?
        mProfileDatabase.readBehaviour.observe(viewLifecycleOwner, Observer { behaviour ->
            for (b in behaviour){
                val newBehavior = BehaviorItems(b.id, b.beschreibung, b.effizienz, b.einfachheit)
                listOfBehaviour.add(newBehavior)
            }
        })

        listOfBehaviour.sortByDescending { it.efficiencyForUse }
        listOfBehaviour.sortByDescending { it.einfachheitForUse}

        val listOfGoldenBehaviors = mutableListOf<String>()
        for (b in listOfBehaviour) {
            listOfGoldenBehaviors.add(b.beschreibungForUse)
        }

        var adapter : RecyclerAdapter2 = RecyclerAdapter2(listOfGoldenBehaviors)
        recyclerView2.adapter = adapter


        val button=view.findViewById<Button>(R.id.weiterZuDesignAnalysisButton)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_analysis5_to_design)

        }



        return view
    }

    class BehaviorItems (val idForUse:Int,
                         val beschreibungForUse:String,
                         val efficiencyForUse :Int?=null,
                         val einfachheitForUse:Int?=null)
}