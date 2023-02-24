package com.example.ep_prototyp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ep_prototyp.R

class Design3 : Fragment() {
    private lateinit var mProfileDatabase:ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mProfileDatabase= ViewModelProvider(this).get(ProfileViewModel::class.java)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_design3, container, false)
        val button=view.findViewById<Button>(R.id.weiterZuPracticeButton)
        val rezept=view.findViewById<TextView>(R.id.rezeptAusgabe)
        setViewRezept(rezept)


        button.setOnClickListener {
            mProfileDatabase.readData.observe(viewLifecycleOwner, Observer { data->
                mProfileDatabase.updateProfile(Profile(1,data[0].name,data[0].notificationZeit,data[0].goal,1))

            })
            Thread.sleep(1000)
            findNavController().navigate(R.id.action_design3_to_practiceMain)

        }


        return view
    }

    private fun setViewRezept(rezept: TextView) {
        mProfileDatabase.readRezeptData.observe(viewLifecycleOwner, Observer { rezeptData->
            rezept.setText("immer wenn ich ${rezeptData[0].rezeptPrompt} werde ich ${rezeptData[0].rezeptBehaviour}, danach werde ich ${rezeptData[0].rezeptCelebration}!")
        })



    }
}