package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ep_prototyp.R
import kotlin.concurrent.thread

class Analysis5 : Fragment(), RecyclerAdapter.OnCardClickListener {

    private lateinit var mProfileDatabase : ProfileViewModel
    private lateinit var recyclerView: RecyclerView
    private var clickPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis5, container, false)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewGoldenBehaviors)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)



        val button=view.findViewById<Button>(R.id.weiterZuDesignAnalysisButton)

        mProfileDatabase.readBehaviour.observe(viewLifecycleOwner, Observer { behaviour ->

           // val testList = mutableListOf<String>("Golden Behavior 1", "Golden Behavior 2", "Golden Behavior 3")
           // val adapter = RecyclerAdapter(testList, 1)

            val listOfBehavior= mutableListOf<Behaviour>()
            val behaviorNames = mutableListOf<String>()

            for(i in behaviour){
                listOfBehavior.add(i)
            }
            if(listOfBehavior.isEmpty()){
                Toast.makeText(requireContext(),"DAS GEHT NET",Toast.LENGTH_SHORT).show()

            }

                listOfBehavior.sortByDescending { it.effizienz!! + it.einfachheit!! }

            var zahler=0
            for (b in listOfBehavior){
                if(zahler<3){
                    behaviorNames.add(b.beschreibung)
                }
                zahler++
            }


            val adapter = RecyclerAdapter(behaviorNames, 1)
            adapter.setCardClickListener(this)
            recyclerView.adapter = adapter
/*
            mProfileDatabase.readRezeptData.observe(viewLifecycleOwner, Observer { rezept ->
                if(rezept.isEmpty()){
                    mProfileDatabase.addRezept(Rezept(0, listOfBehavior[0].beschreibung))
                }else{
                    if(rezept[0].rezeptBehaviour!=listOfBehavior[0].beschreibung){
                        mProfileDatabase.updateRezept(Rezept(0, listOfBehavior[0].beschreibung))
                    }
                }

            })*/

            mProfileDatabase.readRezeptData.observe(viewLifecycleOwner, Observer { rezept ->
                if(rezept.isEmpty()){
                    mProfileDatabase.addRezept(Rezept(0, behaviorNames[clickPosition]))
                }else{
                    if(rezept[0].rezeptBehaviour!=behaviorNames[clickPosition]){
                        mProfileDatabase.updateRezept(Rezept(0, behaviorNames[clickPosition]))
                    }
                }

            })

            //Hier stürzt die App wegen einer NullPointer-Exception ab.

            /*
            val listOfBehavior= mutableListOf<Behaviour>()
            val behaviorNames = mutableListOf<String>()
            for(i in behaviour){
                listOfBehavior.add(i)
            }


            if (listOfBehavior.size == behaviour.size) {
                listOfBehavior.sortByDescending { it.effizienz!! + it.einfachheit!! }
            }


            for (b in listOfBehavior){
                behaviorNames.add(b.beschreibung)
            }


            mProfileDatabase.readRezeptData.observe(viewLifecycleOwner, Observer { rezept ->
                if(rezept.isEmpty()){
                    mProfileDatabase.addRezept(Rezept(0, listOfBehavior[0].beschreibung))
                }else{
                    if(rezept[0].rezeptBehaviour!=listOfBehavior[0].beschreibung){
                        mProfileDatabase.updateRezept(Rezept(0, listOfBehavior[0].beschreibung))
                    }
                }

            })
            */

            //die clickPosition-Variable zeigt, welche Card geklickt wurde!



        })

        button.setOnClickListener {
            findNavController().navigate(R.id.action_analysis5_to_design)

        }

        return view
    }


    override fun onCardClick(position: Int) {
        clickPosition = position
    }


}