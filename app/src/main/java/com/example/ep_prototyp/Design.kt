package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class Design : Fragment() {
    private lateinit var mProfileDatabase:ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_design, container, false)
        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)

        val button=view.findViewById<Button>(R.id.weiterZuDesign2Button)

        button.setOnClickListener {

            val eingabe=view.findViewById<EditText>(R.id.editBehaviorSize)
            längeBehaviourSpeichern(eingabe)
            Toast.makeText(requireContext(),"Länge gespeichert!",Toast.LENGTH_LONG).show()
            val ausgabe=view.findViewById<TextView>(R.id.infoTextDesign1)
            Thread.sleep(2000)
            load(ausgabe)

            findNavController().navigate(R.id.action_design_to_design2)
        }
        return view

    }
    private fun load(ausgabe:TextView){

        mProfileDatabase.readRezeptData.observe(viewLifecycleOwner, Observer { rezept ->
            if(rezept.isEmpty()) {
                mProfileDatabase.createProfile(Profile(0, "Name"))
                Toast.makeText(requireContext(), rezept.toString(), Toast.LENGTH_LONG).show()
            }else{
            Toast.makeText(requireContext(),rezept.toString(),Toast.LENGTH_LONG).show()
        }
        })
    }

    private fun längeBehaviourSpeichern(längeBehaviour:EditText) {
        mProfileDatabase.readRezeptData.observe(viewLifecycleOwner, Observer { data->
            mProfileDatabase.readData.observe(viewLifecycleOwner,Observer{profil->
                if(data.isEmpty()){
                    mProfileDatabase.addRezept(Rezept(0,profil[0].goal.toString(),längeBehaviour.text.toString().toInt()))
                }else{
                    mProfileDatabase.updateRezept(Rezept(1,profil[0].goal.toString(),längeBehaviour.text.toString().toInt(),data[0].rezeptCelebration,data[0].rezeptPrompt))
                }


            })
        })
        Toast.makeText(requireContext(),längeBehaviour.text,Toast.LENGTH_LONG).show()

    }
}