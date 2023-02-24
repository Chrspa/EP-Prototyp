package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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


/*

        val listOfBehaviour = mutableListOf<BehaviorItems>()

        // Ab hier evtl Asynchronität ein Problem?
        mProfileDatabase.readBehaviour.observe(viewLifecycleOwner, Observer { behaviour ->
            for (b in behaviour){
                val newBehavior = BehaviorItems(b.id, b.beschreibung, b.effizienz, b.einfachheit)
                listOfBehaviour.add(newBehavior)
                Toast.makeText(requireContext(),listOfBehaviour[0].beschreibungForUse,Toast.LENGTH_SHORT).show()
            }
        })

        listOfBehaviour.sortByDescending { it.efficiencyForUse!!.toInt() + it.einfachheitForUse!!.toInt()}


        val listOfGoldenBehaviors = mutableListOf<String>()
        for (b in listOfBehaviour) {
            listOfGoldenBehaviors.add(b.beschreibungForUse)
        }

        var adapter = RecyclerAdapter2(listOfGoldenBehaviors)
        recyclerView2.adapter = adapter

        val layoutManager = LinearLayoutManager(context)
        recyclerView2.layoutManager = layoutManager
*/
        val button=view.findViewById<Button>(R.id.weiterZuDesignAnalysisButton)
        val text=view.findViewById<TextView>(R.id.BehaviourSimple)
        val wahl=view.findViewById<TextView>(R.id.textGBwaehleAus)

        var output=""
        mProfileDatabase.readBehaviour.observe(viewLifecycleOwner, Observer { behaviour ->

            var liste= mutableListOf<Behaviour>()
            for(i in behaviour){
                liste.add(i)
            }
            liste.sortByDescending { it.effizienz!! + it.einfachheit!!}

            var index=1

            for(i in liste){
                output+=" platz $index: ${i.beschreibung}\n\n"
                index++
                if(index==3)break
            }
            mProfileDatabase.readRezeptData.observe(viewLifecycleOwner, Observer { rezept ->
                if(rezept.isEmpty()){
                    mProfileDatabase.addRezept(Rezept(0, liste[0].beschreibung))
                }else{
                    if(rezept[0].rezeptBehaviour!=liste[0].beschreibung)mProfileDatabase.updateRezept(Rezept(0, liste[0].beschreibung))
                }


            })
            text.text = output
            wahl.text = "dein neues Behaviour ist ${liste[0].beschreibung} !"
        })





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